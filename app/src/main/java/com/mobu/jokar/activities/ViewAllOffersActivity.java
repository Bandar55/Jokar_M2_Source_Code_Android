package com.mobu.jokar.activities;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.mobu.jokar.R;
import com.mobu.jokar.adapter.ViewAllOfferAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewAllOffersActivity extends AppCompatActivity {
    private ViewAllOfferAdapter viewOfferdAdapter;
    private ArrayList<String> viewOfferList;

    @BindView(R.id.rv_view_offer)
    RecyclerView rvViewOffer;


    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, ViewAllOffersActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_offers);
        ButterKnife.bind(this);

        viewOfferList = new ArrayList<>();
        rvViewOffer.setLayoutManager(new LinearLayoutManager(this));
        viewOfferdAdapter = new ViewAllOfferAdapter(this, viewOfferList);
        rvViewOffer.setAdapter(viewOfferdAdapter);


        prePareData();

    }

    private void prePareData() {
        viewOfferList.add("Mr. Abdul");
        viewOfferList.add("Mr. Akram");
        viewOfferList.add("Mr. Ahmad");
        viewOfferList.add("Mr. Akhil");
        viewOfferdAdapter.notifyDataSetChanged();
    }


    @OnClick({R.id.iv_back})
    void onCliclk(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
        }
    }



}
