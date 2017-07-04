package com.example.xray.kidsplanet;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class Story1_Detail extends Activity {

    // Declare Variables
    ViewPager viewPager;
    PagerAdapter adapter;
    String[] rank = new String[9];
    ArrayList<String> str = new ArrayList<>();
    int[] flag;
    int[] song;
    boolean on = true;
    ImageButton back, home, voice;
    int i;
    String query;
    String id ;
    private static final String DB_Name = "kid.db";
    DataBaseHelper helper;
    MediaPlayer mp;


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
                mp.stop();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                mp.stop();
            }
        });

//        boolean hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);
//        if(hasBackKey) mp.stop();


        Bundle extras = getIntent().getExtras();
        String data = extras.getString("st1");

        if (data.equals("pos1")) {

            song = new  int[]{R.raw.cinderalla_1,R.raw.cinderalla_2, R.raw.cinderalla_3,
                    R.raw.cinderalla_4,R.raw.cinderalla_5, R.raw.cinderalla_6,  R.raw.cinderalla_7,
                    R.raw.cinderalla_8,  R.raw.cinderalla_9,R.raw.cinderalla_9};

            flag = new int[]{R.mipmap.cindrella_1, R.mipmap.cindrella_2,
                    R.mipmap.cindrella_3 ,R.mipmap.cindrella_4,
                    R.mipmap.cindrella_5, R.mipmap.cindrella_6, R.mipmap.cindrella_7,
                    R.mipmap.cindrella_8, R.mipmap.cindrella_9, R.mipmap.cindrella_10};

            i=0;
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

            for (i = 0; i<9 ;i++){
                viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    public void onPageScrollStateChanged(int state) {}
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

                    public void onPageSelected(int position) {
                        // Check if this is the page you want.

                        if(position == i){
                            mp = new MediaPlayer().create(Story1_Detail.this, song[i]);
                            mp.start();
                            on = mp.isPlaying();

                            voice.setOnClickListener(new View.OnClickListener() {

                                @Override
                                public void onClick(View v) {
                                    if (on) {
                                        voice.setImageResource(R.drawable.voice_off);
                                        mp.stop();
                                    } else {
                                        voice.setImageResource(R.drawable.voice_on);
                                        mp = new MediaPlayer().create(Story1_Detail.this, song[i]);
                                        mp.start();
                                    }
                                    on = !on;
                                }
                            });
                        }
                    }
                });

            }



        }

        else if (data.equals("pos2")) {

                flag = new int[]{R.drawable.ic_launcher, R.mipmap.elephant_2,
                        R.mipmap.elephant_3, R.mipmap.elephant_4,
                        R.mipmap.elephant_4, R.mipmap.elephant_4, R.mipmap.elephant_4,
                        R.mipmap.elephant_4, R.mipmap.elephant_5, R.mipmap.elephant_5,
                        R.mipmap.elephant_5, R.mipmap.elephant_5, R.mipmap.elephant_5,R.drawable.ic_launcher};

            i=0;
            query = "Select detail from story";
            Cursor cursor = helper.rawQuery(query);
            cursor.move(9);
            while (cursor.moveToNext()) {
                    if (i<13) {
                        String story_detail = cursor.getString(cursor.getColumnIndex("detail"));
                        str.add(story_detail);
                        i++;

                }
            }
            cursor.close();
            rank = (String[]) str.toArray(new String[str.size()]);

            mp = new MediaPlayer().create(this, R.raw.secret_love_song);
            mp.start();
            on = mp.isPlaying();

            voice.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (on) {
                        voice.setImageResource(R.drawable.voice_off);
                        mp.stop();
                    } else {
                        voice.setImageResource(R.drawable.voice_on);
                        mp = new MediaPlayer().create(Story1_Detail.this, R.raw.secret_love_song);
                        mp.start();
                    }
                    on = !on;
                }
            });
            }

            else if (data.equals("pos3")) {

                flag = new int[]{R.mipmap.lion_1, R.mipmap.lion_2, R.mipmap.lion_3,
                        R.mipmap.lion_3, R.mipmap.lion_4, R.mipmap.lion_5,
                        R.mipmap.lion_5, R.mipmap.lion_6, R.mipmap.lion_6,
                        R.mipmap.lion_6, R.mipmap.lion_7, R.mipmap.lion_8,R.mipmap.lion_9};

            i=0;
            query = "Select detail from story";
            Cursor cursor = helper.rawQuery(query);
            cursor.move(23);
            i = 0;
            while (cursor.moveToNext()) {
                if (i <12) {
                    String story_detail = cursor.getString(cursor.getColumnIndex("detail"));
                    str.add(story_detail);
                    i++;
                }
            }
            cursor.close();
            rank = (String[]) str.toArray(new String[str.size()]);

            mp = new MediaPlayer().create(this, R.raw.secret_love_song);
            mp.start();
            on = mp.isPlaying();

            voice.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (on) {
                        voice.setImageResource(R.drawable.voice_off);
                        mp.stop();
                    } else {
                        voice.setImageResource(R.drawable.voice_on);
                        mp = new MediaPlayer().create(Story1_Detail.this, R.raw.secret_love_song);
                        mp.start();
                    }
                    on = !on;
                }
            });
            }

            else if (data.equals("pos4")) {

            flag = new int[]{R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
                    R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
                    R.drawable.ic_launcher, R.drawable.ic_launcher ,R.drawable.ic_launcher};

            i=0;
            query = "Select detail from story";
            Cursor cursor = helper.rawQuery(query);
            cursor.move(35);
            while (cursor.moveToNext()) {
                if (i <15) {
                    String story_detail = cursor.getString(cursor.getColumnIndex("detail"));
                    str.add(story_detail);
                    i++;
                }
            }
            cursor.close();
            rank = (String[]) str.toArray(new String[str.size()]);

            mp = new MediaPlayer().create(this, R.raw.secret_love_song);
            mp.start();
            on = mp.isPlaying();

            voice.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (on) {
                        voice.setImageResource(R.drawable.voice_off);
                        mp.stop();
                    } else {
                        voice.setImageResource(R.drawable.voice_on);
                        mp = new MediaPlayer().create(Story1_Detail.this, R.raw.secret_love_song);
                        mp.start();
                    }
                    on = !on;
                }
            });
            }

            else if (data.equals("pos5")) {

                flag = new int[]{R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
                        R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,R.drawable.ic_launcher};

            i=0;
            query = "Select detail from story";
            Cursor cursor = helper.rawQuery(query);
            cursor.move(50);
            while (cursor.moveToNext()) {
                if (i <10) {
                    String story_detail = cursor.getString(cursor.getColumnIndex("detail"));
                    str.add(story_detail);
                    i++;
                }
            }
            cursor.close();
            rank = (String[]) str.toArray(new String[str.size()]);

            mp = new MediaPlayer().create(this, R.raw.secret_love_song);
            mp.start();
            on = mp.isPlaying();

            voice.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (on) {
                        voice.setImageResource(R.drawable.voice_off);
                        mp.stop();
                    } else {
                        voice.setImageResource(R.drawable.voice_on);
                        mp = new MediaPlayer().create(Story1_Detail.this, R.raw.secret_love_song);
                        mp.start();
                    }
                    on = !on;
                }
            });
            }


            viewPager = (ViewPager) findViewById(R.id.pager);
            adapter = new Story1_ViewPageAdapter(Story1_Detail.this, rank, flag);
            viewPager.setAdapter(adapter);

        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mp.stop();
    }
    }

