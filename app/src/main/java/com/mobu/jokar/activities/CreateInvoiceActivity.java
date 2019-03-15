package com.mobu.jokar.activities;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mobu.jokar.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateInvoiceActivity extends AppCompatActivity {

    @BindView(R.id.tv_text)
    TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_invoice);
        ButterKnife.bind(this);
        tv_text.setPaintFlags(tv_text.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }
}
