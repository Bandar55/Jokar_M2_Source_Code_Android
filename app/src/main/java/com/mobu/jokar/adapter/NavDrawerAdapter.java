package com.mobu.jokar.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mobu.jokar.R;
import com.mobu.jokar.activities.AddCard;
import com.mobu.jokar.activities.BecomeDeliveryPersonActivity;
import com.mobu.jokar.activities.BecomeProfessionalWorkerActivity;
import com.mobu.jokar.activities.ChangeLanguageActivity;
import com.mobu.jokar.activities.ContactAdmin;
import com.mobu.jokar.activities.HomeMapActivity;
import com.mobu.jokar.activities.ManageAddressActivity;
import com.mobu.jokar.activities.ManageAddresses;
import com.mobu.jokar.activities.MyOrderDashboardActivity;
import com.mobu.jokar.activities.MyProfile;
import com.mobu.jokar.activities.MyRate;
import com.mobu.jokar.activities.MyWallet;
import com.mobu.jokar.activities.SettingActivity;
import com.mobu.jokar.bean.NavDrawerModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NavDrawerAdapter extends RecyclerView.Adapter<NavDrawerAdapter.MyViewHolder> {
    private ArrayList<NavDrawerModel> navlist;
    private Context context;


    public NavDrawerAdapter(Context context, ArrayList<NavDrawerModel> navlist) {
        this.context = context;
        this.navlist = navlist;

    }

    @Override
    public NavDrawerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemtype = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_left_nav, parent, false);
        return new NavDrawerAdapter.MyViewHolder(itemtype);
    }

    @Override
    public void onBindViewHolder(NavDrawerAdapter.MyViewHolder holder, int position) {
        holder.itemName.setText(navlist.get(position).getItemName());
        //int image =navlist.get(position).getImage();
        Glide.with(context).load(navlist.get(position).getImage()).into(holder.itemImg);
        if(position==5||position==6){
            holder.rlMainNav.setBackgroundColor(context.getResources().getColor(R.color.colorPrimaryThin));
        }else {
            holder.rlMainNav.setBackgroundColor(context.getResources().getColor(R.color.white));
        }

        if(position==9 ||position==10 || position==11){
            holder.itemName.setTextColor(context.getResources().getColor(R.color.purpalMedium));
        }else {
            holder.itemName.setTextColor(context.getResources().getColor(R.color.blacklight));
        }

    }

    @Override
    public int getItemCount() {
        return navlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img)
        ImageView itemImg;

        @BindView(R.id.tv_name)
        TextView itemName;

        @BindView(R.id.rl_main_nav)
        RelativeLayout rlMainNav;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


            rlMainNav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    performAction(getAdapterPosition());
                }
            });


        }


    }


    public void performAction(int position) {
        switch (position) {

            case 0:
                context.startActivity(HomeMapActivity.getIntent(context,""));
                break;
            case 1:
                context.startActivity(new Intent(context, MyOrderDashboardActivity.class));
                break;

            case 2:
                context.startActivity(new Intent(context, MyWallet.class));
                break;
            case 3:
                context.startActivity(new Intent(context, ManageAddressActivity.class));
                //context.startActivity(new Intent(context, LoginActivity.class).putExtra("change_package", "change_package"));
                break;
            case 4:
                context.startActivity(new Intent(context, MyProfile.class));
                break;
            case 5:
                context.startActivity(new Intent(context, BecomeDeliveryPersonActivity.class));
                break;
            case 6:
                context.startActivity(new Intent(context, BecomeProfessionalWorkerActivity.class));
                break;
            case 7:
                context.startActivity(new Intent(context, SettingActivity.class));
                break;
            case 8:
                context.startActivity(new Intent(context, ChangeLanguageActivity.class));
                break;
            case 9:
                context.startActivity(new Intent(context, MyRate.class));
                break;
            case 10:
                context.startActivity(new Intent(context, MyProfile.class));
                break;
            case 11:
                context.startActivity(new Intent(context, ContactAdmin.class));
                break;

        }
    }
}
