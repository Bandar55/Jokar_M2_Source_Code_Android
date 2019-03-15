package com.mobu.jokar.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mobu.jokar.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddCard extends AppCompatActivity {

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, AddCard.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_save})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                startActivity(new Intent(this,AddNewBank.class));
                break;
        }
    }
}
