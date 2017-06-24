package com.example.xray.kidsplanet;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;

public class Setting extends AppCompatActivity {
    private PopupWindow mPopWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ImageButton back;
        Button btnRate ,btnAboutUs;
        back = (ImageButton) findViewById(R.id.back);
        btnRate = (Button) findViewById(R.id.btnRate);
        btnAboutUs = (Button) findViewById(R.id.btnAboutUs);

        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnRate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });
        btnAboutUs.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
    }
}