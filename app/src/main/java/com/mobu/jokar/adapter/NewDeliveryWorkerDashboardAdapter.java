package com.mobu.jokar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobu.jokar.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewDeliveryWorkerDashboardAdapter extends RecyclerView.Adapter<NewDeliveryWorkerDashboardAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<String> newList;
    private OnClickReview onClickReview;

    public NewDeliveryWorkerDashboardAdapter(Context context, ArrayList<String> newList, OnClickReview onClickReview) {
        this.context = context;
        this.newList = newList;
        this.onClickReview = onClickReview;
    }

    @NonNull
    @Override
    public NewDeliveryWorkerDashboardAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_new_dashboard_delivery_work,null,false);

        return new NewDeliveryWorkerDashboardAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewDeliveryWorkerDashboardAdapter.MyViewHolder holder, int position) {

    holder.tvProfileName.setText(newList.get(position));
        String offers = "Minimum Offer 10+*";
        SpannableString spannableString  = new SpannableString(offers);
        spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.red)),offers.length(),offers.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.tvMinimumOfferTen.setText(spannableString);
    }

    @Override
    public int getItemCount() {
        return newList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_profile_name)
        TextView tvProfileName;

        @BindView(R.id.tvMinimumOfferTen)
        TextView tvMinimumOfferTen;

        @BindView(R.id.tv_view_comments)
        TextView tv_view_comments;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            tv_view_comments.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickReview.onClickReview(getAdapterPosition());
                }
            });

        }

    }

    public interface OnClickReview{
        void onClickReview(int position);
    }
}
