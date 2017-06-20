package com.example.xray.kidsplanet;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar= getSupportActionBar();
        actionBar.hide();

        ImageButton imgbtnStory , imgbtnPoem , imgbtnEdu;


        imgbtnStory = (ImageButton) findViewById(R.id.img_btnStory);
        imgbtnPoem = (ImageButton) findViewById(R.id.img_btnPoem);
        imgbtnEdu = (ImageButton) findViewById(R.id.img_btnEdu);



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

    }

    }