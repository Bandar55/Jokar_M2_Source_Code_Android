package com.mobu.jokar.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mobu.jokar.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CancellationActivity extends AppCompatActivity {


    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, CancellationActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancellation);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.iv_back, R.id.btn_submit})
    void onCliclk(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_submit:
                finish();
                break;
        }
    }
}
