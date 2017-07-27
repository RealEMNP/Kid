package com.example.xray.kidsplanet;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class About_Us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__us);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}
