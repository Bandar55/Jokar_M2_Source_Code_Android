package com.mobu.jokar.activities;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobu.jokar.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyOrderDashboardActivity extends AppCompatActivity {

    @BindView(R.id.iv_back)
    ImageView iv_back;

    @BindView(R.id.tvNormalUser)
    TextView tvNormalUser;

    @BindView(R.id.tvDeliveryWorker)
    TextView tvDeliveryWorker;

    @BindView(R.id.tvProfessioalWoker)
    TextView tvProfessioalWoker;

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, MyOrderDashboardActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order_dashboard);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.tvNormalUser, R.id.tvDeliveryWorker, R.id.tvProfessioalWoker, R.id.iv_back})
    void onClick(View view) {
        switch (view.getId()) {

            case R.id.tvNormalUser:
                startActivity(HomeMapActivity.getIntent(this,"my_order_deshbord"));
             //   startActivity(new Intent(HomeMapActivity.class,"my_order_deshbord"));
                break;
            case R.id.tvDeliveryWorker:
                startActivity(DeliveryWorkerOrderDashboardActivity.getIntent(this));
                break;
            case R.id.tvProfessioalWoker:
                startActivity(ProfessionalWorkerOrderDashboardActivity.getIntent(this));
                break;

            case R.id.iv_back:
                onBackPressed();
                break;
        }

    }
}
