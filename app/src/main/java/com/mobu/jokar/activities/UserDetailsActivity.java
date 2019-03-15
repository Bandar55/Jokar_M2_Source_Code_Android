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

import com.mobu.jokar.R;
import com.mobu.jokar.adapter.CommentsAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetailsActivity extends AppCompatActivity {
    private ArrayList<String> userCommentsList;
    private CommentsAdapter commentsAdapter;
    @BindView(R.id.rv_comments)
    RecyclerView recyclerViewComments;

    @BindView(R.id.iv_back)
    ImageView ivBack;


    public static Intent getIntent(Context context) {
        return new Intent(context, UserDetailsActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        ButterKnife.bind(this);
        userCommentsList = new ArrayList<>();

        recyclerViewComments.setLayoutManager(new LinearLayoutManager(this));
        commentsAdapter = new CommentsAdapter(this, userCommentsList);
        recyclerViewComments.setAdapter(commentsAdapter);

        recyclerViewComments.addItemDecoration(new DividerItemRecyclerDecoration(this, R.drawable.canvas_recycler_diver_list));

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

        prepareData();

    }

    private void prepareData() {
        userCommentsList.add("Abc");
        userCommentsList.add("Abc");
        userCommentsList.add("Abc");
        userCommentsList.add("Abc");
        userCommentsList.add("Abc");
        userCommentsList.add("Abc");
        userCommentsList.add("Abc");
        commentsAdapter.notifyDataSetChanged();
    }
}
