package com.example.xray.kidsplanet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

public class PoemGridView extends AppCompatActivity{
        GridView grid;
        ImageButton back;
        String[] poem= {"ဖိနပ္ကေလး","လက္ေဆးျကစို့","ပုရြက္ဆိတ္","မနွင္းဆီ","ေဖေဖနဲ့ေမေမရယ္"};
        int[] image={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,
        R.drawable.ic_launcher};

protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poem_grid_view);
        getSupportActionBar().hide();

        back = (ImageButton) findViewById(R.id.img_btnBackPoem);
        back.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                        onBackPressed();
                }
        });


        PoemGridViewItem adapter=new PoemGridViewItem(PoemGridView.this, poem, image);
        grid=(GridView) findViewById(R.id.poem_grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener(){
@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           if(poem[position]=="ဖိနပ္ကေလး"){
                   Intent intent= new Intent(getApplicationContext(), Poem1Detail.class);
                   intent.putExtra("st1","pos1");
                   startActivity(intent);
           }
        if(poem[position]=="လက္ေဆးျကစို့"){
                Intent intent= new Intent(getApplicationContext(), Poem1Detail.class);
                intent.putExtra("st1","pos2");
                startActivity(intent);
        }
        if(poem[position]=="ပုရြက္ဆိတ္"){
                Intent intent= new Intent(getApplicationContext(), Poem1Detail.class);
                intent.putExtra("st1","pos3");
                startActivity(intent);
        }
        if(poem[position]=="မနွင္းဆီ"){
                Intent intent= new Intent(getApplicationContext(), Poem1Detail.class);
                intent.putExtra("st1","pos4");
                startActivity(intent);
        }
        if(poem[position]=="ေဖေဖနဲ့ေမေမရယ္"){
                Intent intent= new Intent(getApplicationContext(), Poem1Detail.class);
                intent.putExtra("st1","pos5");
                startActivity(intent);
        }
        }
        });
}
}