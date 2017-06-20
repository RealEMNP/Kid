package com.example.xray.kidsplanet;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;


public class StoryGridView extends AppCompatActivity{
    GridView grid;
    ImageButton back;
    String[] story= {"Story1","Story2","Story3","Story4","Story5","Pinterest","Quora","Twitter","Vimeo","WordPress",
                     "Youtube","Stumbleupon","SoundCloud","Reddit","Blogger"};
    int[] image={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,
            R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,
            R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,
            R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_grid_view);
        getSupportActionBar().hide();

        back = (ImageButton) findViewById(R.id.img_btnBackStory);
        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        StoryGridViewItem adapter=new StoryGridViewItem(StoryGridView.this, story, image);

        grid=(GridView) findViewById(R.id.story_grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (story[position]=="Story1"){
                    Intent intent= new Intent(getApplicationContext(), Story1Detail.class);
                    intent.putExtra("story1","This is Story1 Detail.");
                    startActivity(intent);
                }
                if (story[position]=="Story2"){
                    Intent intent= new Intent(getApplicationContext(), Story2Detail.class);
                    startActivity(intent);
                }
                if (story[position]=="Story3"){
                    Intent intent= new Intent(getApplicationContext(), Story3Detail.class);
                    startActivity(intent);
                }
                if (story[position]=="Story4"){
                    Intent intent= new Intent(getApplicationContext(), Story4Detail.class);
                    startActivity(intent);
                }
                if (story[position]=="Story5"){
                    Intent intent= new Intent(getApplicationContext(), Story5Detail.class);
                    startActivity(intent);
                }

            }
        });
    }

}