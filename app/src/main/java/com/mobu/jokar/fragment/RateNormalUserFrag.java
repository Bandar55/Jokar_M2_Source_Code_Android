package com.mobu.jokar.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobu.jokar.R;
import com.mobu.jokar.adapter.RateNormalUserAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class RateNormalUserFrag extends Fragment {
    private RateNormalUserAdapter rateNormalUserAdapter;
    private ArrayList<String> normalUserList;

    @BindView(R.id.rv_normal_user)
    RecyclerView rvNormalUser;


    public RateNormalUserFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rate_normal_user, container, false);
        ButterKnife.bind(this, view);
        normalUserList = new ArrayList<>();

        rvNormalUser.setLayoutManager(new LinearLayoutManager(getActivity()));
        rateNormalUserAdapter = new RateNormalUserAdapter(getActivity(), normalUserList);
        rvNormalUser.setAdapter(rateNormalUserAdapter);

        prePareData();
        return view;
    }

    private void prePareData() {
        normalUserList.add("User123");
        normalUserList.add("User124");
        normalUserList.add("User125");
        normalUserList.add("User126");
        normalUserList.add("User127");
        normalUserList.add("User128");
        rateNormalUserAdapter.notifyDataSetChanged();

    }

}
