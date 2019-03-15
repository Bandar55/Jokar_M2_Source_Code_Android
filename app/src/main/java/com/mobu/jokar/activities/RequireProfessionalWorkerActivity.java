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
import com.mobu.jokar.fragment.ActiveRequireProfessionalFrag;
import com.mobu.jokar.fragment.ActiveRequireProfessionalWorkerFrag;
import com.mobu.jokar.fragment.NewRequireProfessionalFrag;
import com.mobu.jokar.fragment.NewRequireProfessionalWorkerFrag;
import com.mobu.jokar.fragment.PastRequireProfessionalFrag;
import com.mobu.jokar.fragment.PastRequireProfessionalWorkerFrag;
import com.mobu.jokar.fragment.PendingRequireProfessionalFrag;
import com.mobu.jokar.fragment.PendingRequireProfessionalWorkerFrag;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RequireProfessionalWorkerActivity extends AppCompatActivity {

    private NewRequireProfessionalWorkerFrag newFrag;
    private PendingRequireProfessionalWorkerFrag pendingFrag;
    private ActiveRequireProfessionalWorkerFrag activeFrag;
    private PastRequireProfessionalWorkerFrag pastFrag;

    @BindView(R.id.tv_new)
    TextView tvNew;
    @BindView(R.id.tv_active)
    TextView tvActive;
    @BindView(R.id.tv_pending)
    TextView tvPandding;
    @BindView(R.id.tv_past)
    TextView tvPast;
@BindView(R.id.iv_back)
ImageView ivBack;

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, RequireProfessionalWorkerActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_require_professional_worker);
        ButterKnife.bind(this);


        newFrag = new NewRequireProfessionalWorkerFrag();
        pendingFrag = new PendingRequireProfessionalWorkerFrag();
        activeFrag = new ActiveRequireProfessionalWorkerFrag();
        pastFrag = new PastRequireProfessionalWorkerFrag();


        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);
        if (fragment != null) {
            removeAllFragments(getSupportFragmentManager());
        } else {
            getSupportFragmentManager().beginTransaction().add(R.id.container, pendingFrag).commit();
            tvNew.setTextColor(getResources().getColor(R.color.blacklight));
            tvActive.setTextColor(getResources().getColor(R.color.blacklight));
            tvPandding.setTextColor(getResources().getColor(R.color.white));
            tvPast.setTextColor(getResources().getColor(R.color.blacklight));
        }
    }

    private static void removeAllFragments(FragmentManager fragmentManager) {
        while (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStackImmediate();
        }
    }

    @OnClick({R.id.tv_new, R.id.tv_pending, R.id.tv_active, R.id.tv_past,R.id.iv_back})
    void onClick(View view) {

        switch (view.getId()) {
            case R.id.tv_new:

                startActivity(HomeMapActivity.getIntent(this, ""));
                //getSupportFragmentManager().beginTransaction().replace(R.id.container, newFrag).commit();
//                tvNew.setTextColor(getResources().getColor(R.color.white));
//                tvActive.setTextColor(getResources().getColor(R.color.blacklight));
//                tvPandding.setTextColor(getResources().getColor(R.color.blacklight));
//                tvPast.setTextColor(getResources().getColor(R.color.blacklight));

                break;
            case R.id.tv_pending:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, pendingFrag).commit();
                tvNew.setTextColor(getResources().getColor(R.color.blacklight));
                tvActive.setTextColor(getResources().getColor(R.color.blacklight));
                tvPandding.setTextColor(getResources().getColor(R.color.white));
                tvPast.setTextColor(getResources().getColor(R.color.blacklight));
                break;
            case R.id.tv_active:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, activeFrag).commit();
                tvNew.setTextColor(getResources().getColor(R.color.blacklight));
                tvActive.setTextColor(getResources().getColor(R.color.white));
                tvPandding.setTextColor(getResources().getColor(R.color.blacklight));
                tvPast.setTextColor(getResources().getColor(R.color.blacklight));
                break;
            case R.id.tv_past:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, pastFrag).commit();
                tvNew.setTextColor(getResources().getColor(R.color.blacklight));
                tvActive.setTextColor(getResources().getColor(R.color.blacklight));
                tvPandding.setTextColor(getResources().getColor(R.color.blacklight));
                tvPast.setTextColor(getResources().getColor(R.color.white));
                break;

            case R.id.iv_back:
                onBackPressed();
                break;


            default:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, pendingFrag).commit();
                tvNew.setTextColor(getResources().getColor(R.color.blacklight));
                tvActive.setTextColor(getResources().getColor(R.color.blacklight));
                tvPandding.setTextColor(getResources().getColor(R.color.white));
                tvPast.setTextColor(getResources().getColor(R.color.blacklight));
                break;

        }
    }
}
