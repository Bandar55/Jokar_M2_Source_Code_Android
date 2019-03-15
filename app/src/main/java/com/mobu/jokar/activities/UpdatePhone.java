package com.mobu.jokar.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mobu.jokar.BottomSheet.OTPBottomSheet;
import com.mobu.jokar.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdatePhone extends AppCompatActivity {

    @BindView(R.id.updatePhoneSubmitBtn)
    Button updatePhoneSubmitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_phone);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.updatePhoneSubmitBtn})

    public void onClick(View view){
        switch (view.getId()){
            case R.id.updatePhoneSubmitBtn:
                showBottomOTPSheet();
                break;
        }

    }

    private void showBottomOTPSheet() {
        OTPBottomSheet bottomSheet = new OTPBottomSheet();
        bottomSheet.show(getSupportFragmentManager(),"OTPBottomSheet");
    }
}
