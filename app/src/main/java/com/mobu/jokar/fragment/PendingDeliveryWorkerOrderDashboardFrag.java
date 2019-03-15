package com.mobu.jokar.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobu.jokar.R;
import com.mobu.jokar.activities.UserDetailsActivity;
import com.mobu.jokar.adapter.PendingDeliveryWorkerDashboardAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PendingDeliveryWorkerOrderDashboardFrag extends Fragment implements PendingDeliveryWorkerDashboardAdapter.OnReviewClickPending {
    PendingDeliveryWorkerDashboardAdapter pendingAdapter;
    ArrayList<String> pendingList;

    @BindView(R.id.rv_pending)
    RecyclerView rvPending;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pending_delivery_worker_order_dashboard_fraghboar, container, false);
        ButterKnife.bind(this, view);

        pendingList = new ArrayList<>();

        rvPending.setLayoutManager(new LinearLayoutManager(getActivity()));
        pendingAdapter = new PendingDeliveryWorkerDashboardAdapter(getActivity(), pendingList,this);
        rvPending.setAdapter(pendingAdapter);

        preParedData();

        return view;
    }

    private void preParedData() {
        pendingList.add("Mr. Abdul");
        pendingList.add("Mr. Rajiv");
        pendingList.add("Mr. Arjun");
        pendingList.add("Mr. Chandan");
        pendingAdapter.notifyDataSetChanged();
    }

    @Override
    public void onReviewClick(int position) {
        startActivity(new Intent(getContext(), UserDetailsActivity.class));
    }
}
