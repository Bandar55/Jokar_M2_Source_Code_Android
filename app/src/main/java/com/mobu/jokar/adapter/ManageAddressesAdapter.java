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

public class ManageAddressesAdapter extends RecyclerView.Adapter<ManageAddressesAdapter.MyCommentHolder> {
    private Context context;
    private ArrayList<String> addressList;

    public ManageAddressesAdapter(Context context, ArrayList<String> addressList) {
        this.context = context;
        this.addressList = addressList;
    }

    @NonNull
    @Override
    public ManageAddressesAdapter.MyCommentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_manage_addresses, null, false);

        return new ManageAddressesAdapter.MyCommentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ManageAddressesAdapter.MyCommentHolder holder, int position) {


        holder.tvType.setText(addressList.get(position));
    }

    @Override
    public int getItemCount() {
        return addressList.size();
    }

    public class MyCommentHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_type)
        TextView tvType;


        public MyCommentHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
