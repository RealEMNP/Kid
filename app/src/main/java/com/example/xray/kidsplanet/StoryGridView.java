package com.example.xray.kidsplanet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;


public class StoryGridView extends AppCompatActivity{
    GridView grid;
    ImageButton back;
    String[] story= new String[]{"စင္ဒရဲလား", "ဘဝင္ျမင့္ေသာဆင္ႀကီး", "ငေတြေဝႏွင့္ ယုန္ကေလး", "နတ္သမီးဆယ္ေယာက္", "ေ႐ွြလမွာ ဆန္ဖြပ္၍"};
    int[] image={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,
            R.drawable.ic_launcher};

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
                if (story[position]=="စင္ဒရဲလား"){
                    Intent intent= new Intent(getApplicationContext(), Story1_Detail.class);
                     intent.putExtra("st1","pos1");
                    startActivity(intent);
                }
                if (story[position]=="ဘဝင္ျမင့္ေသာဆင္ႀကီး"){
                    Intent intent= new Intent(getApplicationContext(), Story1_Detail.class);
                    intent.putExtra("st1","pos2");

                    startActivity(intent);
                }
                if (story[position]=="ငေတြေဝႏွင့္ ယုန္ကေလး"){
                    Intent intent= new Intent(getApplicationContext(), Story1_Detail.class);
                    intent.putExtra("st1","pos3");

                    startActivity(intent);
                }
                if (story[position]=="နတ္သမီးဆယ္ေယာက္"){
                    Intent intent= new Intent(getApplicationContext(), Story1_Detail.class);
                    intent.putExtra("st1","pos4");
                    startActivity(intent);
                }
                if (story[position]=="ေ႐ွြလမွာ ဆန္ဖြပ္၍"){
                    Intent intent= new Intent(getApplicationContext(), Story1_Detail.class);
                    intent.putExtra("st1","pos5");
                    startActivity(intent);
                }

            }
        });
    }

}