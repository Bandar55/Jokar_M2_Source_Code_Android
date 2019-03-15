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

public class PendingProvideServiceProffAdapter extends RecyclerView.Adapter<PendingProvideServiceProffAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<String> newList;

    public PendingProvideServiceProffAdapter(Context context, ArrayList<String> newList) {
        this.context = context;
        this.newList = newList;
    }

    @NonNull
    @Override
    public PendingProvideServiceProffAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_pending_professional_worker_dashboard,null,false);

        return new PendingProvideServiceProffAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PendingProvideServiceProffAdapter.MyViewHolder holder, int position) {

        holder.tvProfileName.setText(newList.get(position));
    }

    @Override
    public int getItemCount() {
        return newList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_profile_name)
        TextView tvProfileName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
