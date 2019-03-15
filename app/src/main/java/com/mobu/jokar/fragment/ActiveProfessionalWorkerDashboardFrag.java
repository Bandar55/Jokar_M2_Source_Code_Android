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
import com.mobu.jokar.activities.ActiveTrackingActivity;
import com.mobu.jokar.activities.CancellationActivity;
import com.mobu.jokar.activities.MessageActivity;
import com.mobu.jokar.activities.RatingAndRiviewActivity;
import com.mobu.jokar.activities.UserDetailsActivity;
import com.mobu.jokar.adapter.ActiveProfessionalWorkerDashboardAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActiveProfessionalWorkerDashboardFrag extends Fragment implements ActiveProfessionalWorkerDashboardAdapter.OnContentClickProActive {
    private ActiveProfessionalWorkerDashboardAdapter activeAdapter;

    ArrayList<String> activeList;


    @BindView(R.id.rv_active)
    RecyclerView rvActive;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_active_professional_worker_dashboard, container, false);
        ButterKnife.bind(this, view);

        activeList = new ArrayList<>();
        rvActive.setLayoutManager(new LinearLayoutManager(getActivity()));
        activeAdapter = new ActiveProfessionalWorkerDashboardAdapter(getActivity(), activeList,this);
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
    public void onReviewClick(int position) {
        startActivity(new Intent(getContext(), UserDetailsActivity.class));
    }

    @Override
    public void onMsgClick(int position) {
        startActivity(new Intent(getContext(), MessageActivity.class));
    }

    @Override
    public void onWorkDoneClick(int position) {
        startActivity(new Intent(getContext(), RatingAndRiviewActivity.class));
    }

    @Override
    public void onCancelOffer(int position) {
        startActivity(new Intent(getContext(), CancellationActivity.class));
    }

    @Override
    public void onTrackClick(int position) {
        startActivity(new Intent(getContext(), ActiveTrackingActivity.class));
    }
}
