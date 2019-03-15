package com.mobu.jokar.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobu.jokar.R;
import com.mobu.jokar.activities.CreateInvoiceActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActiveDeliveryWorkerDashboardAdapter extends RecyclerView.Adapter<ActiveDeliveryWorkerDashboardAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<String> activeList;
    private OnClickContentListener onClickContentListener;

    public ActiveDeliveryWorkerDashboardAdapter(Context context, ArrayList<String> activeList,OnClickContentListener onClickContentListener) {
        this.context = context;
        this.activeList = activeList;
        this.onClickContentListener = onClickContentListener;
    }

    @NonNull
    @Override
    public ActiveDeliveryWorkerDashboardAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_active_dashboard_delivery_worker,null,false);

        return new ActiveDeliveryWorkerDashboardAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActiveDeliveryWorkerDashboardAdapter.MyViewHolder holder, int position) {

        holder.tvProfileName.setText(activeList.get(position));
    }

    @Override
    public int getItemCount() {
        return activeList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_profile_name)
        TextView tvProfileName;

        @BindView(R.id.tvWorkDoneActive)
        TextView tvWorkDoneActive;

        @BindView(R.id.tvCancelOrderActive)
        TextView tvCancelOrderActive;

        @BindView(R.id.iv_msg)
        ImageView iv_msg;

        @BindView(R.id.ivTrack)
        ImageView ivTrack;

        @BindView(R.id.tv_view_comments)
        TextView tv_view_comments;

        @BindView(R.id.tvInvoiceCreated)
        TextView tvInvoiceCreated;




        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            tvWorkDoneActive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickContentListener.onWorkDoneClick(getAdapterPosition());
                }
            });

            tvCancelOrderActive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickContentListener.onClickCancelActive(getAdapterPosition());
                }
            });

            iv_msg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickContentListener.onMagClick(getAdapterPosition());
                }
            });

            ivTrack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickContentListener.onTrackClick(getAdapterPosition());
                }
            });

            tv_view_comments.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickContentListener.onReviewClick(getAdapterPosition());
                }
            });

            tvInvoiceCreated.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, CreateInvoiceActivity.class));
                }
            });
        }
    }

    public interface OnClickContentListener{
        void onWorkDoneClick(int position);
        void onClickCancelActive(int position);
        void onMagClick(int position);
        void onTrackClick(int position);
        void onReviewClick(int position);
    }
}
