package com.mobu.jokar.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.mobu.jokar.R;
import com.mobu.jokar.adapter.NavDrawerAdapter;
import com.mobu.jokar.bean.NavDrawerModel;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NavDrawerActivity extends AppCompatActivity {
    private ArrayList<NavDrawerModel> navDrawerModel;
    private NavDrawerAdapter drawerAdapter;
    @BindView(R.id.rv_navdrawer)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        ButterKnife.bind(this);
        navDrawerModel = new ArrayList<>();
        preParedData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        drawerAdapter = new NavDrawerAdapter(this, navDrawerModel);
        recyclerView.setAdapter(drawerAdapter);


    }


    private void preParedData() {

        navDrawerModel.add(new NavDrawerModel(getString(R.string.nav_home), R.drawable.home));
        navDrawerModel.add(new NavDrawerModel(getString(R.string.nav_my_order), R.drawable.my_orders));
        navDrawerModel.add(new NavDrawerModel(getString(R.string.nav_wallet), R.drawable.my_wallet));
        navDrawerModel.add(new NavDrawerModel(getString(R.string.nav_address), R.drawable.history));
        navDrawerModel.add(new NavDrawerModel(getString(R.string.nav_profile), R.drawable.profile));
        navDrawerModel.add(new NavDrawerModel(getString(R.string.nav_delivry_person), R.drawable.delivery));
        navDrawerModel.add(new NavDrawerModel(getString(R.string.nav_profsnal_wrkr), R.drawable.professional));
        navDrawerModel.add(new NavDrawerModel(getString(R.string.nav_setting), R.drawable.settings));
        navDrawerModel.add(new NavDrawerModel(getString(R.string.nav_arabic), R.drawable.language));
        navDrawerModel.add(new NavDrawerModel(getString(R.string.nav_rate_us), R.drawable.rate_us));
        navDrawerModel.add(new NavDrawerModel(getString(R.string.nav_share_earn), R.drawable.share));
        navDrawerModel.add(new NavDrawerModel(getString(R.string.nav_contact_admin), R.drawable.contact));


    }


    //    All Click
    @OnClick({R.id.nav_back})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.nav_back:
                onBackPressed();
                break;
        }
    }


}
