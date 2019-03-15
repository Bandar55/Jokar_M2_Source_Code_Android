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

public class WalletTranstionHistoryAdapter extends RecyclerView.Adapter<WalletTranstionHistoryAdapter.MyWalletHolder> {
    private Context context;
//    private ArrayList<String> walletList;

    public WalletTranstionHistoryAdapter(Context context) {
        this.context = context;
//        this.walletList = walletList;
    }

    @NonNull
    @Override
    public MyWalletHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_delivery_worker_custom, viewGroup, false);

        return new MyWalletHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyWalletHolder holder, int position) {


        //holder.tvTotalPay.setText(walletList.get(position));
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class MyWalletHolder extends RecyclerView.ViewHolder {

//        @BindView(R.id.tv_total_pay)
//        TextView tvTotalPay;


        public MyWalletHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
