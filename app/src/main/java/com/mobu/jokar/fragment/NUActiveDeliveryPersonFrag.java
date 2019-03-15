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
import com.mobu.jokar.activities.IssuesMyOrderActivity;
import com.mobu.jokar.adapter.ActiveReqiureProfessionalAdapter;
import com.mobu.jokar.adapter.NUActiveDeliveryPersonAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NUActiveDeliveryPersonFrag extends Fragment {

    private NUActiveDeliveryPersonAdapter activeAdapter;
    private ArrayList<String> activeList;

    @BindView(R.id.rv_active)
    RecyclerView rvActive;

    public NUActiveDeliveryPersonFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nuactive_delivery_person, container, false);
        ButterKnife.bind(this,view);

        activeList = new ArrayList<>();

        rvActive.setLayoutManager(new LinearLayoutManager(getActivity()));
        activeAdapter = new NUActiveDeliveryPersonAdapter(getActivity(), activeList);
        rvActive.setAdapter(activeAdapter);

        preParedData();
        findCallback();
        return view;

    }

    private void preParedData() {
        activeList.add("Mr. Abdul");
        activeList.add("Mr. Rajiv");
        activeList.add("Mr. Arjun");
        activeList.add("Mr. Chandan");
        activeAdapter.notifyDataSetChanged();
    }


    private void findCallback() {

       activeAdapter.setListener(new NUActiveDeliveryPersonAdapter.ActiveRequireProff() {
           @Override
           public void onReportOrder(View v, int pos) {
               startActivity(IssuesMyOrderActivity.getIntent(getActivity()));
           }

           @Override
           public void onCancelOrder(View v, int pos) {
               startActivity(CancellationActivity.getIntent(getActivity()));
           }
       });

    }

}
