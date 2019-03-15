package com.mobu.jokar.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mobu.jokar.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyProfile extends AppCompatActivity {
    @BindView(R.id.contactAdminBtnProfile)
    Button contactAdminBtnProfile;

    @BindView(R.id.myCaptionBtn)
    Button myCaptionBtn;

    @BindView(R.id.myRateBtn)
    Button myRateBtn;

    @BindView(R.id.save)
    TextView save;

    @BindView(R.id.tvProfileEdit)
    TextView tvProfileEdit;

    @BindView(R.id.tvMyProfileID)
    TextView tvMyProfileID;

    private String spanString = "My Id #23562365";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        ButterKnife.bind(this);
        SpannableString spannableString = new SpannableString("My Id #23562365");
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorPink)),6,spanString.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvMyProfileID.setText(spannableString);
    }

    @OnClick({R.id.contactAdminBtnProfile,R.id.myCaptionBtn,R.id.myRateBtn,R.id.save,R.id.tvProfileEdit})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.contactAdminBtnProfile:
                dispatchContactAdmin();
                break;
            case R.id.myCaptionBtn:
                startActivity(CaptionProfileActivity.getIntent(MyProfile.this));
                break;
            case R.id.myRateBtn:
                dispatchMyRate();
                break;
            case R.id.save:
                finish();
                break;
            case R.id.tvProfileEdit:
                dipatchUpdatePhone();
                break;
        }
    }

    private void dispatchMyRate() {
        Intent intent = new Intent(this,MyRate.class);
        startActivity(intent);
    }

    private void dispatchContactAdmin() {
        Intent intent = new Intent(this,ContactAdmin.class);
        startActivity(intent);
    }
    private void dipatchUpdatePhone() {
        Intent intent = new Intent(this, UpdatePhone.class);
        startActivity(intent);
    }
}
