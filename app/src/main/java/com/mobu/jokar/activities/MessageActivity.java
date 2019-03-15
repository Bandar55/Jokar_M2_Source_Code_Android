package com.mobu.jokar.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobu.jokar.R;
import com.mobu.jokar.adapter.ChatListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageActivity extends AppCompatActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;


    @BindView(R.id.rv_Chat_list)
    RecyclerView rvChatList;

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, MessageActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
        rvChatList.setLayoutManager(new LinearLayoutManager(this));
        rvChatList.setHasFixedSize(true);
        rvChatList.setAdapter(new ChatListAdapter(this));

        tvTitle.setText("Message");



    }

    @OnClick(R.id.iv_back)
    void onClick(){
        finish();
    }


}
