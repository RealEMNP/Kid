package com.example.xray.kidsplanet;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar= getSupportActionBar();
        actionBar.hide();

        ImageButton imgbtnStory , imgbtnPoem , imgbtnEdu;
        final FloatingActionButton FAB = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        imgbtnStory = (ImageButton) findViewById(R.id.img_btnStory);
        imgbtnPoem = (ImageButton) findViewById(R.id.img_btnPoem);
        imgbtnEdu = (ImageButton) findViewById(R.id.img_btnEdu);
//        imgbtnSetting = (ImageButton) findViewById(R.id.btn_setting);

        imgbtnStory.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), StoryGridView.class);
                startActivity(intent);
            }
        });
        imgbtnPoem.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), PoemGridView.class);
                startActivity(intent);
            }
        });
        imgbtnEdu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), EducationLayout.class);
                startActivity(intent);
            }
        });
        FAB.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
//                Intent intent= new Intent(getApplicationContext(), Setting.class);
//                startActivity(intent);
                overridePendingTransition(R.anim.slide_down,R.anim.slide_down);
                AlertDialog.Builder alertDialogBuilder;
                alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setMessage("\t\t\t\t\t"+"Developed by:" + "\tX-Ray" + "\n\n\t\t\t\t\t\t"+"Email Address:"+"\n"+
                        "bokyawabbk@gmail.com" +"\n"+"sandar1990.s4@gmail.com"+"\n"+"eieikhaingthin2587@gmail.com"+"\n"+"ehmunaphoe18@gmail.com"+"\n\n"+
                        "Computer University Taungoo" + "\n\n\t\t\t\t\t\t\t" + "Version 1.0"+"\n\n"+"Credit to: Original Uploader");

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(alertDialog.getWindow().getAttributes());
                lp.width = 800;
                lp.height = 1000;
//                lp.x = 170;
//                lp.y = 100;
                alertDialog.getWindow().setAttributes(lp);
            }
        });

    }

    }