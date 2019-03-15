package com.mobu.jokar.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mobu.jokar.R;
import com.mobu.jokar.activities.ActiveTrackingActivity;
import com.mobu.jokar.activities.MessageActivity;
import com.mobu.jokar.activities.UserDetailsActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NUActiveProWorkerAdapter extends RecyclerView.Adapter<NUActiveProWorkerAdapter.NUProfWorkerViewHolder> {

    private Context context;
    private ArrayList<String> activeList;
    private NUActiveProWorkerAdapter.ActiveRequireProff listener;

    public NUActiveProWorkerAdapter(Context context, ArrayList<String> activeList) {
        this.context = context;
        this.activeList = activeList;
    }

    @NonNull
    @Override
    public NUProfWorkerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.nu_active_professional_worker_custom, null, false);

        return new NUProfWorkerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NUProfWorkerViewHolder nuProfWorkerViewHolder, int i) {
        nuProfWorkerViewHolder.tvProfileName.setText(activeList.get(i));
    }

    @Override
    public int getItemCount() {
        return activeList.size();
    }

    public void setListener(NUActiveProWorkerAdapter.ActiveRequireProff listener) {
        this.listener = listener;
    }


    public class NUProfWorkerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tv_profile_name)
        TextView tvProfileName;
        @BindView(R.id.tv_report_order)
        TextView tvReportOrder;
        @BindView(R.id.tv_cancel_order)
        TextView tvCancelOrder;
        @BindView(R.id.tvRatingViewAll)
        TextView tvRatingViewAll;

        @BindView(R.id.ll_msg)
        LinearLayout llMsg;

        @BindView(R.id.ll_track)
        LinearLayout llTrack;
        public NUProfWorkerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            tvReportOrder.setOnClickListener(this);
            tvCancelOrder.setOnClickListener(this);
            llMsg.setOnClickListener(this);
            llTrack.setOnClickListener(this);
            tvRatingViewAll.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.tv_report_order:
                    if (listener != null) {
                        listener.onReportOrder(v, getAdapterPosition());
                    }
                    break;

                case R.id.tv_cancel_order:
                    if (listener != null) {
                        listener.onCancelOrder(v, getAdapterPosition());
                    }
                    break;
                case R.id.ll_msg:

                    context.startActivity(MessageActivity.getIntent(context));
                    break;

                case R.id.ll_track:
                    context.startActivity(ActiveTrackingActivity.getIntent(context));
                    break;

                case R.id.tvRatingViewAll:
                    context.startActivity(new Intent(context, UserDetailsActivity.class));
                    break;
            }

        }
    }

    public interface ActiveRequireProff {
        void onReportOrder(View v, int pos);

        void onCancelOrder(View v, int pos);

    }
}
