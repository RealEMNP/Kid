package com.example.xray.kidsplanet;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Story1_Detail extends Activity {

    // Declare Variables
    ViewPager viewPager;
    PagerAdapter adapter;
    String[] rank = new String[9];
    ArrayList<String> str = new ArrayList<>();
    int[] flag;
    boolean on = true;
    ImageButton back, home, voice;
    int i = 0;
    String query;
    String id ;
    private static final String DB_Name = "kid.db";
    DataBaseHelper helper;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story1__detail);

        helper = DataBaseHelper.getInstance(this, DB_Name);


        back = (ImageButton) findViewById(R.id.img_btnBackStory1);
        home = (ImageButton) findViewById(R.id.img_btnStory1toHome);
        voice = (ImageButton) findViewById(R.id.img_btnStory1On);

        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        voice.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (on)
                    voice.setImageResource(R.drawable.voice_off);
                else
                    voice.setImageResource(R.drawable.voice_on);
                on = !on;
            }
        });

        Bundle extras = getIntent().getExtras();
        String data = extras.getString("st1");

        if (data.equals("pos1")) {

            flag = new int[]{R.drawable.ic_launcher, R.drawable.ic_launcher,
                    R.drawable.ic_launcher, R.drawable.ic_launcher,
                    R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
                    R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher};

            query = "Select detail from story";
            Cursor cursor = helper.rawQuery(query);
            while (cursor.moveToNext()) {
                if (i < 9) {
                    String story_detail = cursor.getString(cursor.getColumnIndex("detail"));
                    str.add(story_detail);
                    i++;
                }
            }
            cursor.close();
            rank = (String[]) str.toArray(new String[str.size()]);

        }

        else if (data.equals("pos2")) {

                flag = new int[]{R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher};

            query = "Select detail from story";
            Cursor cursor = helper.rawQuery(query);
            cursor.move(9);
            while (cursor.moveToNext()) {
                    if (i <14) {
                        String story_detail = cursor.getString(cursor.getColumnIndex("detail"));
                        str.add(story_detail);
                        i++;

                }else cursor.isClosed();
            }

            rank = (String[]) str.toArray(new String[str.size()]);
            }

            else if (data.equals("pos3")) {

                flag = new int[]{R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher};

            query = "Select detail from story";
            Cursor cursor = helper.rawQuery(query);
            cursor.move(23);
            i = 0;
            while (cursor.moveToNext()) {
                if (i <13) {
                    String story_detail = cursor.getString(cursor.getColumnIndex("detail"));
                    str.add(story_detail);
                }
            }
            cursor.close();
            rank = (String[]) str.toArray(new String[str.size()]);
            }

            else if (data.equals("pos4")) {

            flag = new int[]{R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
                    R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
                    R.drawable.ic_launcher, R.drawable.ic_launcher};

            query = "Select detail from story";
            Cursor cursor = helper.rawQuery(query);
            cursor.move(35);
            while (cursor.moveToNext()) {
                if (i <16) {
                    String story_detail = cursor.getString(cursor.getColumnIndex("detail"));
                    str.add(story_detail);
                }
            }
            cursor.close();
            rank = (String[]) str.toArray(new String[str.size()]);
            }

            else if (data.equals("pos5")) {

                flag = new int[]{R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,R.drawable.ic_launcher};

            query = "Select detail from story";
            Cursor cursor = helper.rawQuery(query);
            cursor.move(50);
            while (cursor.moveToNext()) {
                if (i <11) {
                    String story_detail = cursor.getString(cursor.getColumnIndex("detail"));
                    str.add(story_detail);
                }
            }
            cursor.close();
            rank = (String[]) str.toArray(new String[str.size()]);
            }


            viewPager = (ViewPager) findViewById(R.id.pager);
            adapter = new Story1_ViewPageAdapter(Story1_Detail.this, rank, flag);
            viewPager.setAdapter(adapter);

        }
    }
