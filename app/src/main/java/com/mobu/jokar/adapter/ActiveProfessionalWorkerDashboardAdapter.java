package com.mobu.jokar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobu.jokar.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActiveProfessionalWorkerDashboardAdapter extends RecyclerView.Adapter<ActiveProfessionalWorkerDashboardAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<String> activeList;
    private OnContentClickProActive onContentClickProActive;

    public ActiveProfessionalWorkerDashboardAdapter(Context context, ArrayList<String> activeList,OnContentClickProActive onContentClickProActive) {
        this.context = context;
        this.activeList = activeList;
        this.onContentClickProActive = onContentClickProActive;
    }

    @NonNull
    @Override
    public ActiveProfessionalWorkerDashboardAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_active_professional_worker_dashboard,null,false);

        return new ActiveProfessionalWorkerDashboardAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActiveProfessionalWorkerDashboardAdapter.MyViewHolder holder, int position) {

        holder.tvProfileName.setText(activeList.get(position));
    }

    @Override
    public int getItemCount() {
        return activeList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_profile_name)
        TextView tvProfileName;
        @BindView(R.id.tv_view_comments)
        TextView tv_view_comments;
        @BindView(R.id.iv_msg)
        ImageView iv_msg;
        @BindView(R.id.tvWorkDoneProAct)
        TextView tvWorkDoneProAct;
        @BindView(R.id.tvCancelOfferProAct)
        TextView tvCancelOfferProAct;
        @BindView(R.id.ivTrack)
        ImageView ivTrack;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            tv_view_comments.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onContentClickProActive.onReviewClick(getAdapterPosition());
                }
            });

            iv_msg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onContentClickProActive.onMsgClick(getAdapterPosition());
                }
            });

            tvWorkDoneProAct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onContentClickProActive.onWorkDoneClick(getAdapterPosition());
                }
            });

            tvCancelOfferProAct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onContentClickProActive.onCancelOffer(getAdapterPosition());
                }
            });

            ivTrack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onContentClickProActive.onTrackClick(getAdapterPosition());
                }
            });
        }
    }

    public interface OnContentClickProActive{
        void onReviewClick(int position);
        void onMsgClick(int position);
        void onWorkDoneClick(int position);
        void onCancelOffer(int position);
        void onTrackClick(int position);
    }
}
