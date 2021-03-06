package com.example.xray.kidsplanet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

public class PoemGridView extends AppCompatActivity{
        GridView grid;
        ImageButton back;
        String[] poem= {"ဥပုသ်စောင့်","တူတူရေဝါး","ရွှေခဲကြက်တူရွေး","ကြက်ဖတိန်ညင်","လယ်စောင့်တဲ"};
        int[] image={R.mipmap.sone_oak_ni_ni,R.mipmap.totoyaywar,R.mipmap.parrot,R.mipmap.kyat_pha_tain_nyine,
        R.mipmap.lal_sount_tae};

protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poem_grid_view);
        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

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
           if(position==0){
                   Intent intent= new Intent(getApplicationContext(), Poem1Detail.class);
                   intent.putExtra("st1","pos1");
                   startActivity(intent);
           }
        if(poem[position]=="တူတူရေဝါး"){
                Intent intent= new Intent(getApplicationContext(), Poem1Detail.class);
                intent.putExtra("st1","pos2");
                startActivity(intent);
        }
        if(poem[position]=="ရွှေခဲကြက်တူရွေး"){
                Intent intent= new Intent(getApplicationContext(), Poem1Detail.class);
                intent.putExtra("st1","pos3");
                startActivity(intent);
        }
        if(poem[position]=="ကြက်ဖတိန်ညင်"){
                Intent intent= new Intent(getApplicationContext(), Poem1Detail.class);
                intent.putExtra("st1","pos4");
                startActivity(intent);
        }
        if(poem[position]=="လယ်စောင့်တဲ"){
                Intent intent= new Intent(getApplicationContext(), Poem1Detail.class);
                intent.putExtra("st1","pos5");
                startActivity(intent);
        }
        }
        });
}
}