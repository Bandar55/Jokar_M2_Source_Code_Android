package com.mobu.jokar.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobu.jokar.R;
import com.mobu.jokar.adapter.PastDeliveryWorkerDashboardAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PastDeliveryWorkerOrderDashboardFrag extends Fragment {
    private PastDeliveryWorkerDashboardAdapter pastAdapter;

    private ArrayList<String> pastList;

    @BindView(R.id.rv_past)
    RecyclerView rvPast;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_past_delivery_worker_order_dashboard, container, false);
        ButterKnife.bind(this, view);

        pastList = new ArrayList<>();

        rvPast.setLayoutManager(new LinearLayoutManager(getActivity()));
        pastAdapter = new PastDeliveryWorkerDashboardAdapter(getActivity(), pastList);
        rvPast.setAdapter(pastAdapter);


        preParedData();
        return view;
    }

    private void preParedData() {
        pastList.add("Tax 5%");
        pastList.add("Tax 6%");
        pastList.add("Tax 7%");
        pastList.add("Tax 8%");
        pastAdapter.notifyDataSetChanged();
    }

}
