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

public class NUPastProfWorkerAdapter extends RecyclerView.Adapter<NUPastProfWorkerAdapter.NUPastProfWorkerViewHolder> {
    private Context context;
    private ArrayList<String> pastList;

    public NUPastProfWorkerAdapter(Context context, ArrayList<String> pastList) {
        this.context = context;
        this.pastList = pastList;
    }
    @NonNull
    @Override
    public NUPastProfWorkerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.nu_past_professional_worker_custom,viewGroup,false);

        return new NUPastProfWorkerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NUPastProfWorkerViewHolder nuPastProfWorkerViewHolder, int i) {
        nuPastProfWorkerViewHolder.tvTax.setText(pastList.get(i));
    }

    @Override
    public int getItemCount() {
        return pastList.size();
    }

    public class NUPastProfWorkerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_tax)
        TextView tvTax;
        public NUPastProfWorkerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
