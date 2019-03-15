package com.mobu.jokar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mobu.jokar.R;
import com.mobu.jokar.activities.RatingAndRiviewActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PastDeliveryWorkerDashboardAdapter extends RecyclerView.Adapter<PastDeliveryWorkerDashboardAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<String> pastList;

    public PastDeliveryWorkerDashboardAdapter(Context context, ArrayList<String> pastList) {
        this.context = context;
        this.pastList = pastList;
    }

    @NonNull
    @Override
    public PastDeliveryWorkerDashboardAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_past_dashboard_delivery_worker,null,false);

        return new PastDeliveryWorkerDashboardAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PastDeliveryWorkerDashboardAdapter.MyViewHolder holder, int position) {

        holder.tvTax.setText(pastList.get(position));
    }

    @Override
    public int getItemCount() {
        return pastList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.tv_tax)
        TextView tvTax;

        @BindView(R.id.rl_rating)
        RelativeLayout rlRating;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            rlRating.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.rl_rating:
                    context.startActivity(RatingAndRiviewActivity.getIntent(context));
                    break;
            }
        }
    }
}
