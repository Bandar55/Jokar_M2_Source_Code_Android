package com.mobu.jokar.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mobu.jokar.BottomSheet.OTPBottomSheet;
import com.mobu.jokar.R;
import com.mobu.jokar.bean.SignUpWithMobileResp;
import com.mobu.jokar.database.SharedPreferenceKey;
import com.mobu.jokar.database.SharedPreferenceWriter;
import com.mobu.jokar.retrofit.ApiClientConnection;
import com.mobu.jokar.retrofit.ApiInterface;
import com.mobu.jokar.retrofit.MyDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpMobileActivity extends AppCompatActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.edtSignInNumber)
    EditText edtPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_mobile);
        ButterKnife.bind(this);
        tvTitle.setText("Sign In");




    }

    private void signUp() {
        MyDialog.getInstance(SignUpMobileActivity.this).hideDialog();
        MyDialog.getInstance(this).showDialog(SignUpMobileActivity.this);
        ApiInterface apiInterface = ApiClientConnection.getInstance().createApiInterface();
        Call<SignUpWithMobileResp> call = apiInterface.signUpWithMobile("+91", edtPhoneNumber.getText().toString());
        call.enqueue(new Callback<SignUpWithMobileResp>() {
            @Override
            public void onResponse(Call<SignUpWithMobileResp> call, Response<SignUpWithMobileResp> response) {
                MyDialog.getInstance(SignUpMobileActivity.this).hideDialog();
                if (response.isSuccessful()) {
                    SignUpWithMobileResp signUpWithMobileResp = response.body();
                    if (signUpWithMobileResp.getStatus().equalsIgnoreCase("SUCCESS")) {

                        Gson gson=new Gson();
                        String data=gson.toJson(response.body());
                        SharedPreferenceWriter.getInstance(SignUpMobileActivity.this).writeStringValue("kSignUpData",data);

                        showBottomSheet();
                        Toast.makeText(SignUpMobileActivity.this, "" + signUpWithMobileResp.getData().getMobileOtp(), Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(SignUpMobileActivity.this, "" + signUpWithMobileResp.getResponseMessage(), Toast.LENGTH_SHORT).show();
                    }

            } else {
                Toast.makeText(SignUpMobileActivity.this, "Error!", Toast.LENGTH_SHORT).show();

            }

            }

            @Override
            public void onFailure(Call<SignUpWithMobileResp> call, Throwable t) {
                MyDialog.getInstance(SignUpMobileActivity.this).hideDialog();
                t.printStackTrace();

            }
        });

    }


    @OnClick({R.id.signInSubmitBtn, R.id.iv_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signInSubmitBtn:
                signUp();

                break;
            case R.id.iv_back:
                onBackPressed();

        }
    }

    private void showBottomSheet() {
        SharedPreferences sharedpreferences = getSharedPreferences("kAppPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("commingTypeMobile", "SignInMobile");
        editor.commit();
        OTPBottomSheet sheet = new OTPBottomSheet();
        sheet.show(getSupportFragmentManager(), "OTPBottomSheet");
    }


}
