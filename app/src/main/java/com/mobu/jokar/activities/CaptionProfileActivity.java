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
import android.widget.Toast;

import com.mobu.jokar.R;
import com.mobu.jokar.fragment.DeliveryManFragment;
import com.mobu.jokar.fragment.ProfessionalFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CaptionProfileActivity extends AppCompatActivity {
    private DeliveryManFragment deliveryManFrag;
    private ProfessionalFragment professionalFrag;

    @BindView(R.id.tv_deliverman)
    TextView tvDeliveryman;
    @BindView(R.id.tv_professional)
    TextView tvProfessional;
    @BindView(R.id.iv_back)
    ImageView btnBack;

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, CaptionProfileActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caption_profile);
        ButterKnife.bind(this);

        deliveryManFrag = new DeliveryManFragment();
        professionalFrag = new ProfessionalFragment();

        tvDeliveryman.setTextColor(getResources().getColor(R.color.white));
        tvProfessional.setTextColor(getResources().getColor(R.color.black));

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);
        if (fragment != null) {
            removeAllFragments(getSupportFragmentManager());
        } else {
            getSupportFragmentManager().beginTransaction().add(R.id.container, deliveryManFrag).commit();
        }

    }

    private static void removeAllFragments(FragmentManager fragmentManager) {
        while (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStackImmediate();
        }
    }

    @OnClick({R.id.tv_deliverman, R.id.tv_professional,R.id.iv_back,R.id.save})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_deliverman:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, deliveryManFrag).commit();
                tvDeliveryman.setTextColor(getResources().getColor(R.color.white));
                tvProfessional.setTextColor(getResources().getColor(R.color.black));

                break;
            case R.id.tv_professional:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, professionalFrag).commit();
                tvDeliveryman.setTextColor(getResources().getColor(R.color.black));
                tvProfessional.setTextColor(getResources().getColor(R.color.white));

                break;


            case R.id.iv_back:
                onBackPressed();
                break;


            case R.id.save:
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
