package com.mobu.jokar.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobu.jokar.R;

import butterknife.ButterKnife;

public class RatingAndRiviewActivity extends AppCompatActivity {


    public static Intent getIntent(Context context){
        Intent intent = new Intent(context,RatingAndRiviewActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_and_riview);
        ButterKnife.bind(this);
    }
}
