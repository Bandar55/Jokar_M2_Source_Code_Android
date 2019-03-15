package com.mobu.jokar.fragment;


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
import com.mobu.jokar.adapter.NewDeliveryWorkerDashboardAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NewOderDashboardDeliverWorkerFrag extends Fragment implements NewDeliveryWorkerDashboardAdapter.OnClickReview {

    @BindView(R.id.rv_new)
    RecyclerView rvNew;

    ArrayList<String> newList;

    private NewDeliveryWorkerDashboardAdapter dashboardAdapter;


    public NewOderDashboardDeliverWorkerFrag() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_oder_dashboard_deliver_worker, container, false);
        ButterKnife.bind(this, view);

        newList = new ArrayList<>();

        rvNew.setLayoutManager(new LinearLayoutManager(getActivity()));
        dashboardAdapter = new NewDeliveryWorkerDashboardAdapter(getActivity(), newList,this);
        rvNew.setAdapter(dashboardAdapter);

        preParedData();
        return view;
    }

    private void preParedData() {
        newList.add("Mr. Abdul");
        newList.add("Mr. Rajiv");
        newList.add("Mr. Arjun");
        newList.add("Mr. Chandan");
        dashboardAdapter.notifyDataSetChanged();
    }


    @Override
    public void onClickReview(int position) {
        startActivity(new Intent(getActivity(), UserDetailsActivity.class));
    }
}
