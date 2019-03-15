package com.mobu.jokar.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobu.jokar.R;
import com.mobu.jokar.fragment.ActiveDeliveryWorkerOrderDashboardFrag;
import com.mobu.jokar.fragment.NewOderDashboardDeliverWorkerFrag;
import com.mobu.jokar.fragment.PastDeliveryWorkerOrderDashboardFrag;
import com.mobu.jokar.fragment.PendingDeliveryWorkerOrderDashboardFrag;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeliveryWorkerOrderDashboardActivity extends AppCompatActivity {

    private NewOderDashboardDeliverWorkerFrag newFrag;
    private PendingDeliveryWorkerOrderDashboardFrag pendingFrag;
    private ActiveDeliveryWorkerOrderDashboardFrag activeFrag;
    private PastDeliveryWorkerOrderDashboardFrag pastFrag;

    @BindView(R.id.tv_new)
    TextView tvNew;

    @BindView(R.id.tv_active)
    TextView tvActive;

    @BindView(R.id.tv_pending)
    TextView tvPandding;

    @BindView(R.id.tv_past)
    TextView tvPast;

    @BindView(R.id.tv_title)
    TextView tvTitle;


    @BindView(R.id.iv_noti)
    ImageView iv_noti;

    @BindView(R.id.iv_back)
    ImageView iv_back;

    @BindView(R.id.iv_backDelivery)
    ImageView btnBack;


    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, DeliveryWorkerOrderDashboardActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_worker_order_dashboard);
        ButterKnife.bind(this);
        btnBack.setVisibility(View.VISIBLE);

        iv_back.setVisibility(View.GONE);
        iv_noti.setVisibility(View.GONE);
        tvTitle.setText("My Order's Dashboard");

        newFrag = new NewOderDashboardDeliverWorkerFrag();
        pendingFrag = new PendingDeliveryWorkerOrderDashboardFrag();
        activeFrag = new ActiveDeliveryWorkerOrderDashboardFrag();
        pastFrag = new PastDeliveryWorkerOrderDashboardFrag();

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);
        if (fragment != null) {
            removeAllFragments(getSupportFragmentManager());
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, newFrag).commit();
        }

        prepareData();

    }

    private void prepareData() {
        tvNew.setTextColor(getResources().getColor(R.color.white));
        tvActive.setTextColor(getResources().getColor(R.color.blacklight));
        tvPandding.setTextColor(getResources().getColor(R.color.blacklight));
        tvPast.setTextColor(getResources().getColor(R.color.blacklight));
    }

    private static void removeAllFragments(FragmentManager fragmentManager) {
        while (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStackImmediate();
        }
    }

    @OnClick({R.id.tv_new, R.id.tv_pending, R.id.tv_active, R.id.tv_past, R.id.iv_backDelivery})
    void onClick(View v) {
        switch (v.getId()) {

            case R.id.tv_new:

                getSupportFragmentManager().beginTransaction().replace(R.id.container, newFrag).commit();
                tvNew.setTextColor(getResources().getColor(R.color.white));
                tvActive.setTextColor(getResources().getColor(R.color.blacklight));
                tvPandding.setTextColor(getResources().getColor(R.color.blacklight));
                tvPast.setTextColor(getResources().getColor(R.color.blacklight));

                break;

            case R.id.tv_pending:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new PendingDeliveryWorkerOrderDashboardFrag()).commit();
                tvNew.setTextColor(getResources().getColor(R.color.blacklight));
                tvActive.setTextColor(getResources().getColor(R.color.blacklight));
                tvPandding.setTextColor(getResources().getColor(R.color.white));
                tvPast.setTextColor(getResources().getColor(R.color.blacklight));
                break;

            case R.id.tv_active:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new ActiveDeliveryWorkerOrderDashboardFrag()).commit();
                tvNew.setTextColor(getResources().getColor(R.color.blacklight));
                tvActive.setTextColor(getResources().getColor(R.color.white));
                tvPandding.setTextColor(getResources().getColor(R.color.blacklight));
                tvPast.setTextColor(getResources().getColor(R.color.blacklight));
                break;

            case R.id.tv_past:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new PastDeliveryWorkerOrderDashboardFrag()).commit();
                tvNew.setTextColor(getResources().getColor(R.color.blacklight));
                tvActive.setTextColor(getResources().getColor(R.color.blacklight));
                tvPandding.setTextColor(getResources().getColor(R.color.blacklight));
                tvPast.setTextColor(getResources().getColor(R.color.white));
                break;

            case R.id.iv_backDelivery:
                onBackPressed();
                break;

            default:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new PendingDeliveryWorkerOrderDashboardFrag()).commit();
                break;


        }
    }
}
