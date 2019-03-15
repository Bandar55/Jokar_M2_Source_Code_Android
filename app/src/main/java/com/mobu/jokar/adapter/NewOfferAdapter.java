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
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewOfferAdapter extends RecyclerView.Adapter<NewOfferAdapter.OfferHolder> {

    private Context context;
    private ArrayList<String> offerList;

    public NewOfferAdapter(Context context, ArrayList<String> offerList) {
        this.context = context;
        this.offerList = offerList;
    }

    @NonNull
    @Override
    public OfferHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_offer_detail_new_pending,null,false);
        return new NewOfferAdapter.OfferHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferHolder offerHolder, int i) {

        offerHolder.tvViewComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(UserDetailsActivity.getIntent(context));
            }
        });

    }

    @Override
    public int getItemCount() {
        return offerList.size();
    }

    public class OfferHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_view_comments)
        TextView tvViewComment;

        public OfferHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
