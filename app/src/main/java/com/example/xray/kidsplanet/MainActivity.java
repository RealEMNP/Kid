package com.example.xray.kidsplanet;

import android.animation.AnimatorSet;
import android.content.DialogInterface;
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
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton imgbtnStory, imgbtnPoem, imgbtnPaint, imgbtnMatch, imgbtnTrace;
     ImageView imgtitle;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imgbtnStory = (ImageButton) findViewById(R.id.img_btnStory);
        imgbtnPoem = (ImageButton) findViewById(R.id.img_btnPoem);
        imgbtnPaint = (ImageButton) findViewById(R.id.img_btnPaint);
        imgbtnMatch = (ImageButton) findViewById(R.id.img_btnMatch);
        imgbtnTrace = (ImageButton) findViewById(R.id.img_btnTrace);
        imgtitle = (ImageView) findViewById(R.id.img_title);
        final FloatingActionButton FAB = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        final Animation animation3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        FAB.startAnimation(animation3);

        imgbtnStory.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), StoryGridView.class);
                startActivity(intent);
            }
        });
        imgbtnPoem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), PoemGridView.class);
                startActivity(intent);
            }
        });
        imgbtnPaint.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), PaintPicture.class);
                startActivity(intent);
            }
        });

        imgbtnMatch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), MatchingActivity.class);
                startActivity(intent);
            }
        });

       imgbtnTrace.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               intent = new Intent(getApplicationContext(), TraceLine.class);
               startActivity(intent);
           }
       });

        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(getApplicationContext(), About_Us.class);
                startActivity(intent);
            }

        });

    }

}
