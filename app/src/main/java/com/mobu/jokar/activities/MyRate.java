package com.mobu.jokar.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobu.jokar.R;
import com.mobu.jokar.fragment.RateDeliveryManFrag;
import com.mobu.jokar.fragment.RateNormalUserFrag;
import com.mobu.jokar.fragment.RateProfessionalFrag;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyRate extends AppCompatActivity {
    private RateNormalUserFrag rateNormalUserFrag;
    private RateProfessionalFrag professionalFrag;
    private RateDeliveryManFrag deliveryManFrag;

    @BindView(R.id.tv_normal_user)
    TextView normalUser;

    @BindView(R.id.tv_professional)
    TextView tvProfessional;

    @BindView(R.id.tv_delivery_man)
    TextView tvDeliveryman;

    @BindView(R.id.ivBackRate)
    ImageView ivBackRate;


    public static Intent getIntent(Context context) {
        return new Intent(context, MyRate.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rate);
        ButterKnife.bind(this);


        rateNormalUserFrag = new RateNormalUserFrag();
        professionalFrag = new RateProfessionalFrag();
        deliveryManFrag = new RateDeliveryManFrag();


        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);
        if (fragment != null) {
            removeAllFragments(getSupportFragmentManager());
        } else {
            getSupportFragmentManager().beginTransaction().add(R.id.container, rateNormalUserFrag).commit();
        }

    }

    private static void removeAllFragments(FragmentManager fragmentManager) {
        while (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStackImmediate();
        }
    }

    @OnClick({R.id.tv_normal_user, R.id.tv_professional, R.id.tv_delivery_man, R.id.ivBackRate})
    void onclick(View view) {
        switch (view.getId()) {
            case R.id.tv_normal_user:

                getSupportFragmentManager().beginTransaction().replace(R.id.container, rateNormalUserFrag).commit();
                normalUser.setTextColor(getResources().getColor(R.color.white));
                tvProfessional.setTextColor(getResources().getColor(R.color.black));
                tvDeliveryman.setTextColor(getResources().getColor(R.color.black));

                break;
            case R.id.tv_professional:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, professionalFrag).commit();
                normalUser.setTextColor(getResources().getColor(R.color.black));
                tvProfessional.setTextColor(getResources().getColor(R.color.white));
                tvDeliveryman.setTextColor(getResources().getColor(R.color.black));

                break;
            case R.id.tv_delivery_man:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, deliveryManFrag).commit();
                normalUser.setTextColor(getResources().getColor(R.color.black));
                tvProfessional.setTextColor(getResources().getColor(R.color.black));
                tvDeliveryman.setTextColor(getResources().getColor(R.color.white));
                break;

            case R.id.ivBackRate:
                onBackPressed();
                break;

            default:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, rateNormalUserFrag).commit();
                break;
        }
    }

}
