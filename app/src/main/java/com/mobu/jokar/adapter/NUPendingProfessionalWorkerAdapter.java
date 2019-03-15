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

public class NUPendingProfessionalWorkerAdapter extends RecyclerView.Adapter<NUPendingProfessionalWorkerAdapter.NUPendingProfWorkViewHolder> {
    private Context context;
    private ArrayList<String> pendingList;
    private NUPendingProfessionalWorkerAdapter.ViewOffersInterface listener;

    public NUPendingProfessionalWorkerAdapter(Context context, ArrayList<String> pendingList) {
        this.context = context;
        this.pendingList = pendingList;
    }
    @NonNull
    @Override
    public NUPendingProfWorkViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.nu_pending_professional_worker_custom, viewGroup, false);

        return new NUPendingProfessionalWorkerAdapter.NUPendingProfWorkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NUPendingProfWorkViewHolder nuPendingProfWorkViewHolder, int i) {
        nuPendingProfWorkViewHolder.tvDistance.setText(pendingList.get(i));
    }

    @Override
    public int getItemCount() {
        return pendingList.size();
    }

    public void setListener(NUPendingProfessionalWorkerAdapter.ViewOffersInterface listener) {
        this.listener = listener;
    }


    public interface ViewOffersInterface {

        void onAllOfferClick(View v, int pos);

        void onEditClick(View v, int pos);

        void onCancelClick(View v, int pos);


    }

    public class NUPendingProfWorkViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tv_distance)
        TextView tvDistance;
        @BindView(R.id.tv_all_offers)
        TextView tvAllOffers;
        @BindView(R.id.tv_edit)
        TextView tvEdit;
        @BindView(R.id.tv_cancel)
        TextView tvCancel;
        public NUPendingProfWorkViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            tvAllOffers.setOnClickListener(this);
            tvEdit.setOnClickListener(this);
            tvCancel.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_all_offers:
                    if (listener != null) {
                        listener.onAllOfferClick(v, getAdapterPosition());
                    }
                    break;

                case R.id.tv_edit:
                    if (listener != null) {
                        listener.onEditClick(v, getAdapterPosition());
                    }
                    break;
                case R.id.tv_cancel:
                    if (listener != null) {
                        listener.onCancelClick(v, getAdapterPosition());
                    }
                    break;
            }
        }
    }
}
