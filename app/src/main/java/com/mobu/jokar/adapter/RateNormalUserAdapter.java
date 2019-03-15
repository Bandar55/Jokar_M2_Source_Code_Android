package com.mobu.jokar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobu.jokar.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RateNormalUserAdapter extends RecyclerView.Adapter<RateNormalUserAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<String> normalUserList;

    public RateNormalUserAdapter(Context context, ArrayList<String> normalUserList) {
        this.context = context;
        this.normalUserList = normalUserList;
    }

    @NonNull
    @Override
    public RateNormalUserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_my_rate, null, false);


        return new RateNormalUserAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RateNormalUserAdapter.MyViewHolder holder, int position) {

        holder.tvUserName.setText(normalUserList.get(position));

    }

    @Override
    public int getItemCount() {
        return normalUserList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_user_name)
        TextView tvUserName;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
