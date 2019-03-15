package com.mobu.jokar.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobu.jokar.R;
import com.mobu.jokar.activities.ActiveTrackingActivity;
import com.mobu.jokar.activities.CancellationActivity;
import com.mobu.jokar.activities.MessageActivity;
import com.mobu.jokar.activities.UserDetailsActivity;
import com.mobu.jokar.adapter.ActiveDeliveryWorkerDashboardAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ActiveDeliveryWorkerOrderDashboardFrag extends Fragment implements ActiveDeliveryWorkerDashboardAdapter.OnClickContentListener {
    private ActiveDeliveryWorkerDashboardAdapter activeAdapter;
    private ArrayList<String> activeList;


    @BindView(R.id.rv_active)
    RecyclerView rvActive;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_active_delivery_worker_order_dashboard, container, false);
        ButterKnife.bind(this, view);

        activeList = new ArrayList<>();

        rvActive.setLayoutManager(new LinearLayoutManager(getActivity()));
        activeAdapter = new ActiveDeliveryWorkerDashboardAdapter(getActivity(), activeList,this);
        rvActive.setAdapter(activeAdapter);


        preParedData();

        return view;

    }

    private void preParedData() {
        activeList.add("Mr. Abdul");
        activeList.add("Mr. Rajiv");
        activeList.add("Mr. Arjun");
        activeList.add("Mr. Chandan");
        activeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onWorkDoneClick(int position) {
        getFragmentManager().beginTransaction().replace(R.id.container,  new PastDeliveryWorkerOrderDashboardFrag()).commit();
    }

    @Override
    public void onClickCancelActive(int position) {
        startActivity(new Intent(getContext(),CancellationActivity.class));
    }

    @Override
    public void onMagClick(int position) {
        startActivity(new Intent(getContext(), MessageActivity.class));
    }

    @Override
    public void onTrackClick(int position) {
        startActivity(new Intent(getContext(), ActiveTrackingActivity.class));
    }

    @Override
    public void onReviewClick(int position) {
        startActivity(new Intent(getActivity(), UserDetailsActivity.class));
    }
}
