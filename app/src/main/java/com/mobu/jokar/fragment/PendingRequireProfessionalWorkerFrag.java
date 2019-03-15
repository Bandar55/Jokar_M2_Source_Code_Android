package com.mobu.jokar.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobu.jokar.R;
import com.mobu.jokar.activities.CancellationActivity;
import com.mobu.jokar.activities.ViewAllOffersActivity;
import com.mobu.jokar.adapter.PendingRequireProfessionalAdapter;
import com.mobu.jokar.adapter.PendingRequireProfessionalWorkerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PendingRequireProfessionalWorkerFrag extends Fragment {

    private PendingRequireProfessionalWorkerAdapter requireAdapter;
    ArrayList<String> pendingList;

    @BindView(R.id.rv_pending)
    RecyclerView rvPending;


    public PendingRequireProfessionalWorkerFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pending_require_professional, container, false);
        ButterKnife.bind(this, view);

        pendingList = new ArrayList<>();


        rvPending.setLayoutManager(new LinearLayoutManager(getActivity()));
        requireAdapter = new PendingRequireProfessionalWorkerAdapter(getActivity(), pendingList);
        rvPending.setAdapter(requireAdapter);

        preParedData();
        allClick();
        return view;
    }

    private void preParedData() {
        pendingList.add("4.18 KM");
        pendingList.add("5.18 KM");
        pendingList.add("3.08 KM");
        pendingList.add("2.08 KM");
    }


    private void allClick() {

        requireAdapter.setListener(new PendingRequireProfessionalWorkerAdapter.ViewOffersInterface() {
            @Override
            public void onAllOfferClick(View v, int pos) {

                startActivity(ViewAllOffersActivity.getIntent(getActivity()));
            }

            @Override
            public void onEditClick(View v, int pos) {
                getActivity().finish();
            }

            @Override
            public void onCancelClick(View v, int pos) {
                startActivity(CancellationActivity.getIntent(getActivity()));
            }
        });
    }

}
