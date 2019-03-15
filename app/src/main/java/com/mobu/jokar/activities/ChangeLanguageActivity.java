package com.mobu.jokar.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.mobu.jokar.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangeLanguageActivity extends AppCompatActivity {
    @BindView(R.id.iv_back)
    ImageView btnBack;
    @BindView(R.id.rl_eng)
    RelativeLayout rlEng;


    boolean isArabic=false;
    boolean isEng = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_language);
        ButterKnife.bind(this);

    }

    //All click...
    @OnClick({R.id.iv_back,  R.id.rl_eng})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;

            case R.id.rl_eng:
                onBackPressed();
                break;
        }
    }
}
