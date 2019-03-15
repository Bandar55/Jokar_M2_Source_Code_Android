package com.mobu.jokar.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobu.jokar.R;
import com.mobu.jokar.adapter.NewProvideServiceProffAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewProvideServiceProffFrag extends Fragment {
    private NewProvideServiceProffAdapter newAdapter;
    private ArrayList<String> newList;


    @BindView(R.id.rv_new)
    RecyclerView rvNew;


    public NewProvideServiceProffFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_provide_service_proff, container, false);
        ButterKnife.bind(this, view);

        newList = new ArrayList<>();

        rvNew.setLayoutManager(new LinearLayoutManager(getActivity()));
        newAdapter = new NewProvideServiceProffAdapter(getActivity(), newList);
        rvNew.setAdapter(newAdapter);

        preParedData();


        return view;

    }

    private void preParedData() {
        newList.add("Mr. Abdul");
        newList.add("Mr. Rajiv");
        newList.add("Mr. Arjun");
        newList.add("Mr. Chandan");
        newAdapter.notifyDataSetChanged();
    }

}
