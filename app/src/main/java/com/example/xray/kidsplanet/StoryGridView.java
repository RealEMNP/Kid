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
    String[] story= new String[]{"စင်ဒရဲလား", "ဘဝင်မြင့်သောဆင်ကြီး", "ငတွေဝေနှင့်ယုန်ကလေး", "နတ်သမီးဆယ်ယောက်", "ရွှေလမှာဆန်ဖွတ်၍"};
    int[] image={R.mipmap.c_final,R.mipmap.e_6,R.mipmap.lion_9_10,R.mipmap.a_8,
            R.mipmap.s_10};

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
        grid.setVerticalScrollBarEnabled(true);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (story[position]=="စင်ဒရဲလား"){
                    Intent intent= new Intent(getApplicationContext(), Story1_Detail.class);
                     intent.putExtra("st1","pos1");
                    startActivity(intent);
                }
                if (story[position]=="ဘဝင်မြင့်သောဆင်ကြီး"){
                    Intent intent= new Intent(getApplicationContext(), Story1_Detail.class);
                    intent.putExtra("st1","pos2");

                    startActivity(intent);
                }
                if (story[position]=="ငတွေဝေနှင့်ယုန်ကလေး"){
                    Intent intent= new Intent(getApplicationContext(), Story1_Detail.class);
                    intent.putExtra("st1","pos3");

                    startActivity(intent);
                }
                if (story[position]=="နတ်သမီးဆယ်ယောက်"){
                    Intent intent= new Intent(getApplicationContext(), Story1_Detail.class);
                    intent.putExtra("st1","pos4");
                    startActivity(intent);
                }
                if (story[position]=="ရွှေလမှာဆန်ဖွတ်၍"){
                    Intent intent= new Intent(getApplicationContext(), Story1_Detail.class);
                    intent.putExtra("st1","pos5");
                    startActivity(intent);
                }

            }
        });
    }

}