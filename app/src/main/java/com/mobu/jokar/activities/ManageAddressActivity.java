package com.mobu.jokar.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.mobu.jokar.R;
import com.mobu.jokar.adapter.ManageAddressesAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ManageAddressActivity extends AppCompatActivity {
    private ManageAddressesAdapter addressesAdapter;
    ArrayList<String> addressesList;


    @BindView(R.id.rv_m_addresses)
    RecyclerView addressRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_address);
        ButterKnife.bind(this);


        addressesList = new ArrayList<>();

        addressRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        addressesAdapter = new ManageAddressesAdapter(this, addressesList);
        addressRecyclerView.setAdapter(addressesAdapter);


        preParedData();
    }

    private void preParedData() {

        addressesList.add("My Home");
        addressesList.add("My Office");
        addressesList.add("My Office");
        addressesList.add("My Home");

        addressesAdapter.notifyDataSetChanged();

    }
}
