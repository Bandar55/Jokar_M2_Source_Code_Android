package com.mobu.jokar.activities;

import android.app.Dialog;

import android.content.Intent;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.mobu.jokar.R;
import com.mobu.jokar.adapter.SelectTimeAdapter;
import com.mobu.jokar.helper.GPSTracker;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeMapActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private double Lat, Long;
    private ArrayList<LatLng> markerPoints;
    @BindView(R.id.r_layout_main)
    RelativeLayout relativeLayoutMain;
    private CopyOnWriteArrayList<String> dataData;
    private SelectTimeAdapter selectTimeAdapter;
    private DrawerLayout mDrawerLayout;

    @BindView(R.id.btnComments)
    ImageView btnComments;
    @BindView(R.id.iv_back)
    ImageView navLeft;
    @BindView(R.id.iv_noti)
    ImageView ivNoti;
    @BindView(R.id.cantainer)
    ConstraintLayout clayoutServicesYou;
    @BindView(R.id.container_you_want)
    ConstraintLayout clayoutYouWant;
    @BindView(R.id.container_select_services)
    ConstraintLayout clayoutSelectServices;

    private String activityCommingType = "";


    public static Intent getIntent(Context context, String type) {
        Intent intent = new Intent(context, HomeMapActivity.class);
        intent.putExtra("kData", type);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_map);
        ButterKnife.bind(this);

        if (getIntent() != null) {
            activityCommingType = (String) getIntent().getSerializableExtra("kData");
        }
        relativeLayoutMain.setVisibility(View.GONE);
        GPSTracker gpsTracker = new GPSTracker(this, this);
        Lat = gpsTracker.getLatitude();
        Long = gpsTracker.getLongitude();
        markerPoints = new ArrayList<>();

        if (activityCommingType.equalsIgnoreCase("my_order_deshbord")) {

            clayoutSelectServices.setVisibility(View.VISIBLE);
            clayoutYouWant.setVisibility(View.GONE);
        }else if(activityCommingType.equalsIgnoreCase("deliverydashboard")){
            clayoutSelectServices.setVisibility(View.VISIBLE);
            clayoutYouWant.setVisibility(View.GONE);
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapview);
        mapFragment.getMapAsync(this);

        // showDialog();
        dataData = new CopyOnWriteArrayList<>();


        prepareData();
    }

    private void prepareData() {
        dataData.add("WithIn 1 hour");
        dataData.add("WithIn 2 hour");
        dataData.add("WithIn 3 hour");
        dataData.add("WithIn 4 hour");
        dataData.add("WithIn 5+ hour");
        dataData.add("WithIn 10 hour");
        dataData.add("WithIn 11 hour");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng current = new LatLng(Lat, Long);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(current, 12));

        markerPoints.add(current);

    }

//buttomsheet navigation open

    private void openBottomSheetBanner() {
        View view = getLayoutInflater().inflate(R.layout.custom_buttonsheet_layout, null);
        final Dialog mBottomSheetDialog = new Dialog(this, R.style.MaterialDialogSheetAnimation);
        mBottomSheetDialog.setContentView(view);
        mBottomSheetDialog.setCancelable(true);
        mBottomSheetDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mBottomSheetDialog.getWindow().setGravity(Gravity.BOTTOM);
        mBottomSheetDialog.show();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        RecyclerView recyclerView = mBottomSheetDialog.findViewById(R.id.rv_bottom_sheet);
        selectTimeAdapter = new SelectTimeAdapter(this, dataData);
        recyclerView.setAdapter(selectTimeAdapter);

        recyclerView.setLayoutManager(linearLayoutManager);
        selectTimeAdapter.notifyDataSetChanged();
    }


    //All Click..
    @OnClick({R.id.tv_select_time, R.id.iv_back, R.id.btn_required, R.id.btn_provide, R.id.btn_prfsnal_offer_near_you, R.id.btn_prfsnal_worker,
            R.id.btn_derlivery_offer_near_you, R.id.btn_derlivery_prsn, R.id.iv_noti})
    void onClick(View view) {
        switch (view.getId()) {

            case R.id.tv_select_time:
                openBottomSheetBanner();
                break;

            case R.id.iv_back:
                Intent intent = new Intent(HomeMapActivity.this, NavDrawerActivity.class);
                startActivity(intent);
                // mDrawerLayout.openDrawer(GravityCompat.START);
                break;

            case R.id.btn_required:
                clayoutSelectServices.setVisibility(View.VISIBLE);
                clayoutYouWant.setVisibility(View.GONE);

                break;
            case R.id.btn_provide:
                clayoutServicesYou.setVisibility(View.VISIBLE);
                clayoutYouWant.setVisibility(View.GONE);
                break;

            case R.id.btn_prfsnal_offer_near_you:
                startActivity(ProvideServiceProffOfferActivity.getIintent(HomeMapActivity.this));
                break;

            case R.id.btn_derlivery_offer_near_you:
                startActivity(HomeOfferDetailsActivity.getIntent(HomeMapActivity.this));
                break;

            case R.id.btn_prfsnal_worker:
                if (activityCommingType.equalsIgnoreCase("my_order_deshbord")) {

                    // MapProfessinalWorkerActivity.getIntent(this,"");
                    startActivity(NUProfessionalWorkerDashboardActivity.getIntent(HomeMapActivity.this));
                } else {
                    startActivity(MapProfessinalWorkerActivity.getIntent(HomeMapActivity.this, "btn_prfsnal_worker"));
                }

                break;
            case R.id.btn_derlivery_prsn:
                if (activityCommingType.equalsIgnoreCase("my_order_deshbord")) {

                    //MapProfessinalWorkerActivity.getIntent(this,"");
                    startActivity(NUDeliveryPersonDashboardActivity.getIntent(HomeMapActivity.this));
                } else {
                    startActivity(MapProfessinalWorkerActivity.getIntent(HomeMapActivity.this, "btn_derlivery_prsn"));
                }

                break;
            case R.id.iv_noti:
                startActivity(NotificationActivity.getIntent(HomeMapActivity.this));
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

}
