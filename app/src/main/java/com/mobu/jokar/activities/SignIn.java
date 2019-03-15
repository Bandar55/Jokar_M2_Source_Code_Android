package com.mobu.jokar.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mobu.jokar.BottomSheet.OTPBottomSheet;
import com.mobu.jokar.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignIn extends AppCompatActivity {

    @BindView(R.id.signInSubmitBtn)
    Button signInSubmitBtn;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    public static Intent getIntent(Context context) {
        return new Intent(context, SignIn.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
        tvTitle.setText("Sign In");

    }

    @OnClick({R.id.signInSubmitBtn, R.id.iv_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signInSubmitBtn:
                showBottomSheet();
                break;
            case R.id.iv_back:
                onBackPressed();

        }
    }

    private void showBottomSheet() {

        SharedPreferences sharedpreferences = getSharedPreferences("kAppPreferences", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedpreferences.edit();


        editor.putString("commingType","SignIn");
        editor.commit();

        OTPBottomSheet sheet = new OTPBottomSheet();
        sheet.show(getSupportFragmentManager(), "OTPBottomSheet");
    }
}
