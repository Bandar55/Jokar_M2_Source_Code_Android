package com.mobu.jokar.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobu.jokar.R;
import com.mobu.jokar.activities.UserDetailsActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewAllOfferAdapter extends RecyclerView.Adapter<ViewAllOfferAdapter.MyWalletHolder> {
    private Context context;
    private ArrayList<String> viewOfferList;

    public ViewAllOfferAdapter(Context context, ArrayList<String> viewOfferList) {
        this.context = context;
        this.viewOfferList = viewOfferList;
    }

    @NonNull
    @Override
    public ViewAllOfferAdapter.MyWalletHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_view_all_offers, viewGroup, false);

        return new ViewAllOfferAdapter.MyWalletHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAllOfferAdapter.MyWalletHolder holder, int position) {


        holder.tvProfileName.setText(viewOfferList.get(position));
    }

    @Override
    public int getItemCount() {
        return viewOfferList.size();
    }

    public class MyWalletHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.tv_profile_name)
        TextView tvProfileName;

        @BindView(R.id.btn_accept_offer)
        Button btnAccept;

        @BindView(R.id.tvRatingViewAllOffers)
        TextView tvRatingViewAllOffers;


        public MyWalletHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            btnAccept.setOnClickListener(this);
            tvRatingViewAllOffers.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_accept_offer:
                    dialogSubmitSuccess();
                    break;
                case R.id.tvRatingViewAllOffers:
                    context.startActivity(new Intent(context, UserDetailsActivity.class));
                    break;
            }
        }
    }


    private void dialogSubmitSuccess() {
        final Dialog dialog = new Dialog(context, R.style.ThemeDialogCustom);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_submit_successfully_layout);


        TextView txtMsg = (TextView) dialog.findViewById(R.id.tv_desc);
        TextView btnOK = (TextView) dialog.findViewById(R.id.tv_ok);
        ImageView image = (ImageView) dialog.findViewById(R.id.image);
        image.setImageDrawable(context.getDrawable(R.drawable.popup_logo));
        txtMsg.setText("Offer Accept Successfully!");


        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();

            }
        });


        dialog.show();

    }
}
