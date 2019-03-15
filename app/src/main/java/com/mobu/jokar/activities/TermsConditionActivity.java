package com.mobu.jokar.activities;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mobu.jokar.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TermsConditionActivity extends AppCompatActivity {
    @BindView(R.id.checkbox)
    CheckBox checkBox;


    public static Intent getIntent(Context context, String activityText) {
        Intent intent = new Intent(context, TermsConditionActivity.class);
//        intent.putExtra(kType, activityText);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_condition);
        ButterKnife.bind(this);

    }


    //All click:
    @OnClick({R.id.btn_next})
    void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_next:
                if(checkBox.isChecked()) {
                    showDialogInstruction();
                }else {
                    Toast.makeText(this, "Please Click on checkbox", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


    private void showDialogInstruction() {
        final Dialog dialog = new Dialog(this, R.style.ThemeDialogCustom);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_instraction);

       dialog.findViewById(R.id.tv_ok).setOnClickListener(v ->{
           dialog.dismiss();
           showDialog();
       });
        dialog.findViewById(R.id.tv_cancel).setOnClickListener(v -> {

            dialog.dismiss();
        });


        dialog.show();

    }


    private void showDialog() {
        final Dialog dialog = new Dialog(this, R.style.ThemeDialogCustom);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_terms_condition_layout);

        dialog.findViewById(R.id.img_cancel2).setOnClickListener(v -> {
           startActivity(HomeMapActivity.getIntent(TermsConditionActivity.this,""));
           finish();
            dialog.dismiss();
        });


        dialog.show();

    }
}
