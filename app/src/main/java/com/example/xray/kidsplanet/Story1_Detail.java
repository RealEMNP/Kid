package com.example.xray.kidsplanet;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Story1_Detail extends Activity {

    // Declare Variables
    ViewPager viewPager;
    PagerAdapter adapter;
    String[] rank = new String[9];
    int[] flag;
    boolean on = true;
    ImageButton back , home ,voice;
    int i = 0;
    String query;
    private  static final String DB_Name = "database.db";
    DataBaseHelper helper ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story1__detail);

        helper = DataBaseHelper.getInstance(this, DB_Name);



        back = (ImageButton) findViewById(R.id.img_btnBackStory1);
        home = (ImageButton) findViewById(R.id.img_btnStory1toHome);
        voice = (ImageButton) findViewById(R.id.img_btnStory1On);

        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        home.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        voice.setOnClickListener(new View.OnClickListener(){

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
        String data=extras.getString("st1");

        if(data.equals("pos1")){
//            rank = new String[] { "This is story1_1", "This is story1_2", "This is story1_3", "This is story1_4",
//                    "This is story1_5", "This is story1_6", "This is story1_7", "This is story1_8", "This is story1_9",
//                    "This is story1_10" };
//
            flag = new int[] { R.drawable.ic_launcher, R.drawable.ic_launcher,
                    R.drawable.ic_launcher, R.drawable.ic_launcher,
                    R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
                    R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher };

            query = "Select detail from story";
            Cursor cursor = helper.rawQuery(query);
            if(cursor != null && cursor.getCount() != 0) {
                Toast.makeText(this,"example",Toast.LENGTH_SHORT).show();
                if (cursor.moveToFirst()) {
                    if (i < 9) {
                        do {
                            rank[i] = cursor.getString(cursor.getColumnIndex("detail"));
                            i++;
                        } while (cursor.moveToNext());
                    }
                }
            }





//            if(cursor != null && cursor.getCount() != 0){
//                if(cursor.moveToFirst()){
//                    do{
//                        rank[i] = cursor.getString(cursor.getColumnIndex("detail"));
//                    }while (cursor.moveToNext());
//                }
//            }
        }
        else if(data.equals("pos2")){
            rank = new String[] { "This is story1_1", "This is story1_2", "This is story1_3", "This is story1_4",
                    "This is story1_5", "This is story1_6", "This is story1_7", "This is story1_8", "This is story1_9",
                    "This is story1_10" };

            flag = new int[] { R.drawable.ic_launcher, R.drawable.ic_launcher,
                    R.drawable.ic_launcher, R.drawable.ic_launcher,
                    R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
                    R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher };
        }
        else if(data.equals("pos3")){
            rank = new String[] { "This is story1_1", "This is story1_2", "This is story1_3", "This is story1_4",
                    "This is story1_5", "This is story1_6", "This is story1_7", "This is story1_8", "This is story1_9",
                    "This is story1_10" };

            flag = new int[] { R.drawable.ic_launcher, R.drawable.ic_launcher,
                    R.drawable.ic_launcher, R.drawable.ic_launcher,
                    R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
                    R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher };
        }
        else if(data.equals("pos4")){
            rank = new String[] { "This is story1_1", "This is story1_2", "This is story1_3", "This is story1_4",
                    "This is story1_5", "This is story1_6", "This is story1_7", "This is story1_8", "This is story1_9",
                    "This is story1_10" };

            flag = new int[] { R.drawable.ic_launcher, R.drawable.ic_launcher,
                    R.drawable.ic_launcher, R.drawable.ic_launcher,
                    R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
                    R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher };
        }
        else if(data.equals("pos5")){
            rank = new String[] { "This is story1_1", "This is story1_2", "This is story1_3", "This is story1_4",
                    "This is story1_5", "This is story1_6", "This is story1_7", "This is story1_8", "This is story1_9",
                    "This is story1_10" };

            flag = new int[] { R.drawable.ic_launcher, R.drawable.ic_launcher,
                    R.drawable.ic_launcher, R.drawable.ic_launcher,
                    R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
                    R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher };
        }



        viewPager = (ViewPager) findViewById(R.id.pager);
        adapter = new Story1_ViewPageAdapter(Story1_Detail.this, rank, flag);
        viewPager.setAdapter(adapter);

    }
}