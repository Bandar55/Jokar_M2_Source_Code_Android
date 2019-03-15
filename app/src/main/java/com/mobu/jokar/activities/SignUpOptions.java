package com.mobu.jokar.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mobu.jokar.activities.SignIn;
import com.mobu.jokar.activities.SignUp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.mobu.jokar.R;

public class SignUpOptions extends AppCompatActivity {
    @BindView(R.id.startSignInBtn)
    Button startSignInBtn;
    @BindView(R.id.startSignUpBtn)
    Button startSignUpBtn;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    public static Intent getIntent(Context context){
        return new Intent(context,SignUpOptions.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tvTitle.setVisibility(View.GONE);
    }
    @OnClick({R.id.startSignInBtn,R.id.startSignUpBtn,R.id.iv_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.startSignInBtn:
                dispatchSignInActivity();
                break;
            case R.id.startSignUpBtn:
                dispatchSignUp();
                break;
            case R.id.iv_back:
                onBackPressed();
                break;
        }
    }
    private void dispatchSignUp() {
        Intent intent = new Intent(this, SignUpMobileActivity.class);
        startActivity(intent);
    }
    private void dispatchSignInActivity() {
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);
    }
}
