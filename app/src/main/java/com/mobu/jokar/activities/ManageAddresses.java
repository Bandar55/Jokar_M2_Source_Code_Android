package com.mobu.jokar.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobu.jokar.R;

import butterknife.ButterKnife;

public class ManageAddresses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_addresses);
        ButterKnife.bind(this);
    }
}
