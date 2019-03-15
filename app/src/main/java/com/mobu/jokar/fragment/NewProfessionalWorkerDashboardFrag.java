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
import com.mobu.jokar.adapter.NewProfessionalWorkerDashboardAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewProfessionalWorkerDashboardFrag extends Fragment implements NewProfessionalWorkerDashboardAdapter.OnContentClickProfessionalNew {
    private NewProfessionalWorkerDashboardAdapter professionalAdapter;

    ArrayList<String> newList;

    @BindView(R.id.rv_new)
    RecyclerView rvNew;




    public NewProfessionalWorkerDashboardFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_professional_worker_dashboard, container, false);
        ButterKnife.bind(this,view);

        newList = new ArrayList<>();

        rvNew.setLayoutManager(new LinearLayoutManager(getActivity()));
        professionalAdapter = new NewProfessionalWorkerDashboardAdapter(getActivity(),newList,this);
        rvNew.setAdapter(professionalAdapter);


        preParedData();
        return view;
    }



    private void preParedData() {
        newList.add("Mr. Abdul");
        newList.add("Mr. Rajiv");
        newList.add("Mr. Arjun");
        newList.add("Mr. Chandan");
        professionalAdapter.notifyDataSetChanged();
    }

    @Override
    public void onReviewClick(int position) {
        startActivity(new Intent(getContext(), UserDetailsActivity.class));
    }
}
