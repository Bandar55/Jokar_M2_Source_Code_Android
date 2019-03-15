package com.mobu.jokar.activities;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.google.firebase.iid.FirebaseInstanceId;
import com.mobu.jokar.R;
import com.mobu.jokar.database.SharedPreferenceKey;
import com.mobu.jokar.database.SharedPreferenceWriter;

public class SplashActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_TIMER = 6000;
    private String device_token ="";
    private static final int PERMISSION_REQUEST_CODE = 12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getDeviceToken();


        if(checkPermissions()){

            onLocation();

        }


    }

    private void onLocation() {
        Handler handler = new Handler();
        int TIMEDALEYSLASHSCREEN = 3000;
        handler.postDelayed(() -> {
            Intent mainIntent = new Intent(SplashActivity.this, TakeTourActivity.class);
            startActivity(mainIntent);
            finish();
        }, TIMEDALEYSLASHSCREEN);

    }

    @TargetApi(Build.VERSION_CODES.P)
    @RequiresApi(api = Build.VERSION_CODES.P)
    private boolean checkPermissions() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,}, PERMISSION_REQUEST_CODE);
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            switch (requestCode) {
                case PERMISSION_REQUEST_CODE:
                    try {
                        startActivity(new Intent(SplashActivity.this, TakeTourActivity.class));
                        finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        } else {
            Toast.makeText(this, "Please accept permissions due to security purpose", Toast.LENGTH_SHORT).show();
            //checkPermissions();
        }
    }

    private void getDeviceToken() {

        final Thread thread = new Thread() {
            @Override
            public void run() {
                Log.e(">>>>>>>>>>>>>>", "thred IS  running");
                SharedPreferenceWriter mPreference = SharedPreferenceWriter.getInstance(getApplicationContext());
                try {
                    if (mPreference.getString(SharedPreferenceKey.DEVICE_TOKEN).isEmpty()) {
                        String token = FirebaseInstanceId.getInstance().getToken();
//                        String token = android.provider.Settings.Secure.getString(getApplicationContext().getContentResolver(),
//                                android.provider.Settings.Secure.ANDROID_ID);
                        //String token="";
                        Log.e("Generated Device Token", "-->" + token);
                        if (token == null) {
                            getDeviceToken();
                        } else {
                            mPreference.writeStringValue(SharedPreferenceKey.DEVICE_TOKEN, token);
                        }
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                super.run();
            }
        };
        thread.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences sharedpreferences = getSharedPreferences("kAppPreferences", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putBoolean("kIsFirstTime", true);
        editor.commit();
    }
}
