package com.mobu.jokar.fragment;

import android.app.Dialog;
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
import android.view.Window;
import android.widget.TextView;

import com.mobu.jokar.R;
import com.mobu.jokar.activities.CancellationActivity;
import com.mobu.jokar.activities.UserDetailsActivity;
import com.mobu.jokar.adapter.PendingProfessionalWorkerDashboardAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PendingProfessionalWorkerDashboardFrag extends Fragment implements PendingProfessionalWorkerDashboardAdapter.OnContentClickPendingPro {
    private PendingProfessionalWorkerDashboardAdapter pendingAdapter;
    ArrayList<String> pendingList;


    @BindView(R.id.rv_pending)
    RecyclerView rvPending;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pending_professional_worker_dashboard, container, false);
        ButterKnife.bind(this, view);

        pendingList = new ArrayList<>();

        rvPending.setLayoutManager(new LinearLayoutManager(getActivity()));
        pendingAdapter = new PendingProfessionalWorkerDashboardAdapter(getActivity(),pendingList,this);
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
        startActivity(new Intent(getActivity(), UserDetailsActivity.class));
    }

    @Override
    public void onMakeNewOfferClick(int position) {
        showMakeNewOfferDialog();
    }

    @Override
    public void onCancelClick(int position) {
        startActivity(new Intent(getActivity(), CancellationActivity.class));
    }

    private void showMakeNewOfferDialog() {
        final Dialog dialog = new Dialog(getContext(), R.style.ThemeDialogCustom);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_make_new_offer_dialog);
        TextView tv_no = (TextView) dialog.findViewById(R.id.tv_no);
        TextView tv_yes = (TextView) dialog.findViewById(R.id.tv_yes);

        tv_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
