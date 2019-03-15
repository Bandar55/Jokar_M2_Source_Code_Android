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

public class NewProfessionalWorkerDashboardAdapter extends RecyclerView.Adapter<NewProfessionalWorkerDashboardAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<String> newList;
    private OnContentClickProfessionalNew onContentClickProfessionalNew;

    public NewProfessionalWorkerDashboardAdapter(Context context, ArrayList<String> newList,OnContentClickProfessionalNew onContentClickProfessionalNew) {
        this.context = context;
        this.newList = newList;
        this.onContentClickProfessionalNew = onContentClickProfessionalNew;
    }

    @NonNull
    @Override
    public NewProfessionalWorkerDashboardAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_new_professional_worker_dashboard,null,false);

        return new NewProfessionalWorkerDashboardAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewProfessionalWorkerDashboardAdapter.MyViewHolder holder, int position) {

        holder.tvProfileName.setText(newList.get(position));
        SpannableString spannableString = new SpannableString("Minimum Offer 10+*");
        spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.red)),17,18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.tvMinOffer.setText(spannableString);
    }

    @Override
    public int getItemCount() {
        return newList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_profile_name)
        TextView tvProfileName;
        @BindView(R.id.tv_view_comments)
        TextView tv_view_comments;

        @BindView(R.id.tv_min_offer)
        TextView tvMinOffer;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            tv_view_comments.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onContentClickProfessionalNew.onReviewClick(getAdapterPosition());
                }
            });

        }
    }

    public interface OnContentClickProfessionalNew{
        void onReviewClick(int position);
    }
}
