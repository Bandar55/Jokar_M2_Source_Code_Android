package com.mobu.jokar.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.mobu.jokar.R;
import com.mobu.jokar.activities.CancellationActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PendingDeliveryWorkerDashboardAdapter extends RecyclerView.Adapter<PendingDeliveryWorkerDashboardAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<String> pendingList;
    private OnReviewClickPending onReviewClickPending;

    public PendingDeliveryWorkerDashboardAdapter(Context context, ArrayList<String> pendingList,OnReviewClickPending onReviewClickPending) {
        this.context = context;
        this.pendingList = pendingList;
        this.onReviewClickPending = onReviewClickPending;
    }

    @NonNull
    @Override
    public PendingDeliveryWorkerDashboardAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_pending_dashboard_delivery_worker,null,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PendingDeliveryWorkerDashboardAdapter.MyViewHolder holder, int position) {

        holder.tvProfileName.setText(pendingList.get(position));
    }

    @Override
    public int getItemCount() {
        return pendingList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_profile_name)
        TextView tvProfileName;

        @BindView(R.id.tvMakeNewOffer)
        TextView tvMakeNewOffer;

        @BindView(R.id.tvCancelOrderOffer)
        TextView tvCancelOrderOffer;

        @BindView(R.id.tv_view_comments)
        TextView tv_view_comments;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            tvMakeNewOffer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showMakeNewOfferDialog();
                }
            });

            tvCancelOrderOffer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     context.startActivity(new Intent(context, CancellationActivity.class));
                }
            });

            tv_view_comments.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onReviewClickPending.onReviewClick(getAdapterPosition());
                }
            });

        }

        private void showMakeNewOfferDialog() {
            final Dialog dialog = new Dialog(context, R.style.ThemeDialogCustom);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.layout_make_new_offer_dialog);
            TextView tv_no = (TextView) dialog.findViewById(R.id.tv_no);
            TextView tv_yes = (TextView) dialog.findViewById(R.id.tv_yes);

            tv_no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }


    }

    public interface OnReviewClickPending{
        void onReviewClick(int position);
    }
}
