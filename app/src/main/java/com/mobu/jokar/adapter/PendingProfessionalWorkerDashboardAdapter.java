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

public class PendingProfessionalWorkerDashboardAdapter extends RecyclerView.Adapter<PendingProfessionalWorkerDashboardAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<String> newList;
    private OnContentClickPendingPro onContentClickPendingPro;

    public PendingProfessionalWorkerDashboardAdapter(Context context, ArrayList<String> newList, OnContentClickPendingPro onContentClickPendingPro) {
        this.context = context;
        this.newList = newList;
        this.onContentClickPendingPro = onContentClickPendingPro;

    }

    @NonNull
    @Override
    public PendingProfessionalWorkerDashboardAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_pending_professional_worker_dashboard,null,false);

        return new PendingProfessionalWorkerDashboardAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PendingProfessionalWorkerDashboardAdapter.MyViewHolder holder, int position) {

        holder.tvProfileName.setText(newList.get(position));
    }

    @Override
    public int getItemCount() {
        return newList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_profile_name)
        TextView tvProfileName;

        @BindView(R.id.tv_view_comments)
        TextView tv_view_comments;

        @BindView(R.id.tvMakeNewOfferPro)
        TextView tvMakeNewOfferPro;

        @BindView(R.id.tvCancelOrderPro)
        TextView tvCancelOrderPro;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            tv_view_comments.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onContentClickPendingPro.onReviewClick(getAdapterPosition());
                }
            });

            tvMakeNewOfferPro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onContentClickPendingPro.onMakeNewOfferClick(getAdapterPosition());
                }
            });

            tvCancelOrderPro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onContentClickPendingPro.onCancelClick(getAdapterPosition());
                }
            });

        }
    }

    public interface OnContentClickPendingPro{
        void onReviewClick(int position);
        void onMakeNewOfferClick(int position);
        void onCancelClick(int position);
    }
}
