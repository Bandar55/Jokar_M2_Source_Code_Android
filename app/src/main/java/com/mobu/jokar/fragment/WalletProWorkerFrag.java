package com.mobu.jokar.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.mobu.jokar.R;
import com.mobu.jokar.activities.AddMoney;
import com.mobu.jokar.activities.ContactAdmin;
import com.mobu.jokar.activities.PayYourCredit;
import com.mobu.jokar.activities.WalletManageCard;
import com.mobu.jokar.adapter.WalletTranstionHistoryAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class WalletProWorkerFrag extends Fragment {

//    private ArrayList<String> walletList;
    private WalletTranstionHistoryAdapter historyAdapter;

    @BindView(R.id.rv_proWorker_history)
    RecyclerView rv_proWorker_history;

    @BindView(R.id.rl_add_money)
    RelativeLayout rlAddMoney;

    @BindView(R.id.rl_manage_mycard)
    RelativeLayout rlManageMyCard;

    @BindView(R.id.rl_our_bank_account)
    RelativeLayout rlOurBankAc;

    @BindView(R.id.rl_contact_admin)
    RelativeLayout rlContactAdmin;




    public WalletProWorkerFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wallet_pro_worker, container, false);
        ButterKnife.bind(this, view);


//        walletList = new ArrayList<>();

        rv_proWorker_history.setLayoutManager(new LinearLayoutManager(getActivity()));
        historyAdapter = new WalletTranstionHistoryAdapter(getActivity());
        rv_proWorker_history.setAdapter(historyAdapter);


//        preParedData();


        return view;

    }
//    private void preParedData() {
//        walletList.add("15.0 SAR");
//        walletList.add("15.0 SAR");
//        walletList.add("15.0 SAR");
//        walletList.add("15.0 SAR");
//        walletList.add("15.0 SAR");
//        walletList.add("15.0 SAR");
//        historyAdapter.notifyDataSetChanged();
//    }


    @OnClick({R.id.rl_add_money, R.id.rl_manage_mycard, R.id.rl_our_bank_account, R.id.rl_contact_admin})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_add_money:
                startActivity(AddMoney.getIntent(getActivity()));
                break;
            case R.id.rl_manage_mycard:
                startActivity(WalletManageCard.getIintent(getActivity()));
                break;
            case R.id.rl_our_bank_account:
                startActivity(PayYourCredit.getIntent(getActivity()));
                break;
            case R.id.rl_contact_admin:
                startActivity(ContactAdmin.getIntent(getActivity()));
                break;

        }
    }

}
