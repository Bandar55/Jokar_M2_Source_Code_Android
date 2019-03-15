package com.mobu.jokar.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.mobu.jokar.R;
import com.mobu.jokar.adapter.BankToBankTranferAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BankToBankTransfer extends AppCompatActivity {
    private BankToBankTranferAdapter tranferAdapter;
    private ArrayList<String> bankTransferList;


    @BindView(R.id.rv_bank_to_bank)
    RecyclerView rvBanktoBank;

    @BindView(R.id.ivBackToTransfer)
    ImageView ivBackToTransfer;

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, BankToBankTransfer.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_to_bank_transfer);
        ButterKnife.bind(this);


        bankTransferList = new ArrayList<>();
        rvBanktoBank.setLayoutManager(new LinearLayoutManager(this));
        tranferAdapter = new BankToBankTranferAdapter(this, bankTransferList);
        rvBanktoBank.setAdapter(tranferAdapter);

        preParedData();

    }

    private void preParedData() {
        bankTransferList.add("4785964758");
        bankTransferList.add("0011155996");
        bankTransferList.add("4755558666");
        bankTransferList.add("5288889999");
        tranferAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.ivBackToTransfer})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ivBackToTransfer:
                finish();
                break;
        }
    }
}
