package com.mobu.jokar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobu.jokar.R;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ChatHolder> {

    Context context;

    public ChatListAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getItemViewType(int position) {
        if (position%2==0){
            return 1;
        }else {
            return 2;
        }
    }

    @NonNull
    @Override
    public ChatHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if(i == 1){
            view= LayoutInflater.from(context).inflate(R.layout.left_chat,viewGroup,false);
        }else{
            view= LayoutInflater.from(context).inflate(R.layout.right_chat,viewGroup,false);
        }
        return new ChatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatHolder chatHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ChatHolder extends RecyclerView.ViewHolder {
        public ChatHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
