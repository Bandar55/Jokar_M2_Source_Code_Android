package com.mobu.jokar.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mobu.jokar.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IssuesMyOrderActivity extends AppCompatActivity {

    @BindView(R.id.btn_submit)
    Button btnSubmit;

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, IssuesMyOrderActivity.class);
        return intent;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issues_my_order);
        ButterKnife.bind(this);


    }
    @OnClick({R.id.btn_submit})
    void onClick(View v){
        switch (v.getId()){
            case R.id.btn_submit:
                finish();
                break;

        }

    }
}
