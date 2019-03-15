package com.mobu.jokar.fragment;

import android.content.Context;
import android.net.Uri;
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


public class RateDeliveryManFrag extends Fragment {

    private RateNormalUserAdapter rateNormalUserAdapter;
    private ArrayList<String> normalUserList;

    @BindView(R.id.rv_normal_user)
    RecyclerView rv_normal_user;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rate_normal_user, container, false);
        ButterKnife.bind(this, view);
        normalUserList = new ArrayList<>();

        rv_normal_user.setLayoutManager(new LinearLayoutManager(getActivity()));
        rateNormalUserAdapter = new RateNormalUserAdapter(getActivity(), normalUserList);
        rv_normal_user.setAdapter(rateNormalUserAdapter);

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
