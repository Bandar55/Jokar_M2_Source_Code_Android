package com.mobu.jokar.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mobu.jokar.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContactAdmin extends AppCompatActivity {

    @BindView(R.id.customerServiceAdminBtn)
    TextView customerServiceAdminBtn;


    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, ContactAdmin.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_admin);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.customerServiceAdminBtn,R.id.iv_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.customerServiceAdminBtn:

                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }

}
