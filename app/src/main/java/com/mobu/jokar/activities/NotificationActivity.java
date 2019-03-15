package com.mobu.jokar.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobu.jokar.R;
import com.mobu.jokar.adapter.NotificationAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationActivity extends AppCompatActivity {
    private NotificationAdapter notiAdapter;
    private ArrayList<String> notiList;


    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.rv_noti)
    RecyclerView rvNoti;

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, NotificationActivity.class);
        return intent;

    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        tvTitle.setText("Notification");

        notiList = new ArrayList<>();


        rvNoti.setLayoutManager(new LinearLayoutManager(this));
        notiAdapter = new NotificationAdapter(this, notiList);
        rvNoti.setAdapter(notiAdapter);

        preParedata();


    }

    private void preParedata() {
        notiList.add("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        notiList.add("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        notiList.add("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        notiList.add("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        notiList.add("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        notiList.add("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        notiList.add("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        notiAdapter.notifyDataSetChanged();
    }
}
