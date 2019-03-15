package com.mobu.jokar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobu.jokar.R;
import com.mobu.jokar.activities.RatingAndRiviewActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NUPastDeliveryPersonAdapter extends RecyclerView.Adapter<NUPastDeliveryPersonAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<String> pastList;

    public NUPastDeliveryPersonAdapter(Context context, ArrayList<String> pastList) {
        this.context = context;
        this.pastList = pastList;
    }

    @NonNull
    @Override
    public NUPastDeliveryPersonAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_nu_past_delivery_person, null, false);

        return new NUPastDeliveryPersonAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NUPastDeliveryPersonAdapter.MyViewHolder holder, int position) {

        holder.tvTax.setText(pastList.get(position));
    }

    @Override
    public int getItemCount() {
        return pastList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_tax)
        TextView tvTax;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }


        @OnClick({R.id.rl_ratingClick})
        void onClick(View v) {
            switch (v.getId()) {
                case R.id.rl_ratingClick:
                    context.startActivity(RatingAndRiviewActivity.getIntent(context));
                    break;
            }
        }
    }
}
