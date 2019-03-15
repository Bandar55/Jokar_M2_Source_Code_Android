package com.mobu.jokar.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobu.jokar.R;


import java.util.concurrent.CopyOnWriteArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectTimeAdapter extends RecyclerView.Adapter<SelectTimeAdapter.HourHolder>{
    private Context context;
    private CopyOnWriteArrayList<String> dataData;

    public SelectTimeAdapter(Context context, CopyOnWriteArrayList<String> dataData) {
        this.context=context;
        this.dataData=dataData;
    }

    @NonNull
    @Override
    public HourHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_select_tym_list_layout,null,false);
        return new HourHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HourHolder hourHolder, int position) {

        hourHolder.tvTime.setText(dataData.get(position));


    }

    @Override
    public int getItemCount() {
        return dataData.size();
    }

    public class HourHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_timeList)
        TextView tvTime;
        public HourHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @OnClick({R.id.tv_timeList})
        void onClick(View view){
            switch (view.getId()){
                case R.id.tv_timeList:
                    tvTime.setTextColor(context.getResources().getColor(R.color.colorPrimary));
                    break;
            }
        }

    }

}
