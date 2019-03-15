package com.mobu.jokar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobu.jokar.R;
import com.mobu.jokar.activities.MessageActivity;
import com.mobu.jokar.adapter.ActiveDeliveryWorkerDashboardAdapter;
import com.mobu.jokar.adapter.PendingDeliveryWorkerDashboardAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentActive extends Fragment implements ActiveDeliveryWorkerDashboardAdapter.OnClickContentListener {

    private ActiveDeliveryWorkerDashboardAdapter activeAdapter;
    private ArrayList<String> activeList;

    @BindView(R.id.rv_active)
    RecyclerView rvActive;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View  view=inflater.inflate(R.layout.fragment_active_details,container,false);
        ButterKnife.bind(this,view);


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

    }

    @Override
    public void onClickCancelActive(int position) {

    }

    @Override
    public void onMagClick(int position) {
        startActivity(new Intent(getContext(),MessageActivity.class));
    }

    @Override
    public void onTrackClick(int position) {

    }

    @Override
    public void onReviewClick(int position) {

    }
}