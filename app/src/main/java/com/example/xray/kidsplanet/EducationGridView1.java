
package com.example.xray.kidsplanet;

import android.content.Intent;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


public class EducationGridView1 extends AppCompatActivity {
    boolean on = true;
    int count = 0;
    private GestureOverlayView gesture;

//    GestureOverlayView gestureOverlayView;
//    private Bitmap bitmap;


    static final int image1[] = {R.drawable.zero, R.drawable.one , R.drawable.two,
            R.drawable.three, R.drawable.four, R.drawable.five,
            R.drawable.six, R.drawable.seven, R.drawable.eight,R.drawable.nine};

    static final int image2[] = {R.drawable.a, R.drawable.b , R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,
            R.drawable.g, R.drawable.h, R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,
            R.drawable.o, R.drawable.p, R.drawable.q,R.drawable.r,R.drawable.s,R.drawable.t,R.drawable.u,R.drawable.v,
            R.drawable.w,R.drawable.x,R.drawable.y,R.drawable.z};



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_grid_view1);
        getSupportActionBar().hide();


        final ImageButton back, home , voice , backward ,forward;


        final ImageView imgview = (ImageView) findViewById(R.id.imgEduGVD1);
        gesture = (GestureOverlayView) findViewById(R.id.gestures);
//        gestureOverlayView = (GestureOverlayView) findViewById()
        back = (ImageButton) findViewById(R.id.img_btnBackEduGVD1);
        home = (ImageButton) findViewById(R.id.img_btnEduGVD1toHome);
        voice = (ImageButton) findViewById(R.id.img_btnEduGVD1On);
        forward = (ImageButton) findViewById(R.id.img_btnForward);
        backward = (ImageButton) findViewById(R.id.img_btnBackward);



        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        voice.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(on)
                    voice.setImageResource(R.drawable.voice_off);
                else
                    voice.setImageResource(R.drawable.voice_on);
                on = !on;
            }
        });

        Bundle extras=getIntent().getExtras();
        String data=extras.getString("btn");

        if(data.equals("eng_123")){
            imgview.setImageResource(image1[0]);
            forward.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    backward.setVisibility(View.VISIBLE);
                    if(count==8){
                        forward.setVisibility(View.INVISIBLE);

                    }

                    if(count<image1.length-1){
                        ++count;
                        imgview.setImageResource(image1[count]);
                    }
                    else {
                        imgview.setImageResource(image1[0]);
                    }
                }
            });
            backward.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    --count;
                    if(count == 0) {
                        backward.setVisibility(View.INVISIBLE);
                        forward.setVisibility(View.VISIBLE);
                        imgview.setImageResource(image1[count]);
                    }
                    else {
                        imgview.setImageResource(image1[count]);
                        forward.setVisibility(View.VISIBLE);
                    }

                }
            });
        }
        else if(data.equals("abc")){
            imgview.setImageResource(image2[0]);
            forward.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    backward.setVisibility(View.VISIBLE);
                    if(count==24){
                        forward.setVisibility(View.INVISIBLE);

                    }

                    if(count<image2.length-1){
                        ++count;
                        imgview.setImageResource(image2[count]);
                    }
                    else {
                        imgview.setImageResource(image2[0]);
                    }
                }
            });
            backward.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    --count;
                    if(count == 0) {
                        backward.setVisibility(View.INVISIBLE);
                        forward.setVisibility(View.VISIBLE);
                        imgview.setImageResource(image2[count]);
                    }
                    else {
                        imgview.setImageResource(image2[count]);
                        forward.setVisibility(View.VISIBLE);
                    }

                }
            });
        }
        }
    }


