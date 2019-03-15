package com.mobu.jokar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobu.jokar.R;

public class ProWorkerDeliveryAdapter extends RecyclerView.Adapter<ProWorkerDeliveryAdapter.ProWorkerViewHolder> {

    Context context;

    public ProWorkerDeliveryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ProWorkerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_delivery_worker_custom,viewGroup,false);

        return new ProWorkerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProWorkerViewHolder proWorkerViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ProWorkerViewHolder extends RecyclerView.ViewHolder {


        public ProWorkerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
