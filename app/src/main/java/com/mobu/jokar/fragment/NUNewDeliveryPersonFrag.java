package com.mobu.jokar.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobu.jokar.R;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NUNewDeliveryPersonFrag extends Fragment {


    public NUNewDeliveryPersonFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nunew_delivery_person, container, false);
        ButterKnife.bind(this,view);





        return view;

    }

}
