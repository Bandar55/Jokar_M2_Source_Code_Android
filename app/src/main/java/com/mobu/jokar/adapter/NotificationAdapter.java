package com.mobu.jokar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobu.jokar.R;
import com.mobu.jokar.activities.UserDetailsActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.OfferHolder> {

    private Context context;
    private ArrayList<String> notiList;

    public NotificationAdapter(Context context, ArrayList<String> notiList) {
        this.context = context;
        this.notiList = notiList;
    }

    @NonNull
    @Override
    public NotificationAdapter.OfferHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_notification, null, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);

        return new NotificationAdapter.OfferHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.OfferHolder holder, int position) {

        holder.tvNotitxt.setText(notiList.get(position));

    }

    @Override
    public int getItemCount() {
        return notiList.size();
    }

    public class OfferHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_noti_txt)
        TextView tvNotitxt;

        public OfferHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
