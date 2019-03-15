package com.mobu.jokar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobu.jokar.R;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.MyCommentHolder> {
    private Context context;
    private ArrayList<String> commentList;

    public CommentsAdapter(Context context, ArrayList<String> commentList) {
        this.context = context;
        this.commentList = commentList;
    }

    @NonNull
    @Override
    public MyCommentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_comments,null,false);

        return new MyCommentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCommentHolder myCommentHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    public class MyCommentHolder extends RecyclerView.ViewHolder {
        public MyCommentHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
