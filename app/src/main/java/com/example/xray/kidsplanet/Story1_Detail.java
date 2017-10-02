package com.example.xray.kidsplanet;

import android.content.Intent;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import java.util.ArrayList;

import mm.technomation.mmtext.mmtext;

public class Story1_Detail extends Activity {

    // Declare Variables
    ViewPager viewPager;
    PagerAdapter adapter;
    String[] rank = new String[9];
    ArrayList<String> str = new ArrayList<>();
    int[] flag;
    int[] song;
    boolean on = true;
    ImageButton back, home, voice, backward, forward;
    int i;
    String query;
    String id ;
    private static final String DB_Name = "kid.db";
    DataBaseHelper helper;
    MediaPlayer mp;
    int count = 0;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story1__detail);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        helper = DataBaseHelper.getInstance(this, DB_Name);


        back = (ImageButton) findViewById(R.id.img_btnBackStory1);
        home = (ImageButton) findViewById(R.id.img_btnStory1toHome);
        voice = (ImageButton) findViewById(R.id.img_btnStory1On);
        viewPager = (ViewPager) findViewById(R.id.pager);
        forward = (ImageButton) findViewById(R.id.img_btnForward);
//        backward = (ImageButton) findViewById(R.id.img_btnBackward);

        mmtext.prepareActivity(this,mmtext.TEXT_UNICODE,true,true);

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

        Bundle extras = getIntent().getExtras();
        String data = extras.getString("st1");

        if (data.equals("pos1")) {

            song = new  int[]{R.raw.cinderalla_1,R.raw.cinderalla_2, R.raw.cinderalla_3,
                    R.raw.cinderalla_4,R.raw.cinderalla_5, R.raw.cinderalla_6,  R.raw.cinderalla_7,
                    R.raw.cinderalla_8,  R.raw.cinderalla_9};

            flag = new int[]{R.mipmap.c_1,R.mipmap.c_2, R.mipmap.c_3,
                    R.mipmap.c_4,R.mipmap.c_5, R.mipmap.c_6,  R.mipmap.c_7,R.mipmap.c_8,
                    R.mipmap.c_final,  R.drawable.ic_launcher};

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

            mp = new MediaPlayer().create(Story1_Detail.this, song[0]);
            mp.start();

            on = mp.isPlaying();
            voice.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (on) {
                        voice.setImageResource(R.drawable.music_off);
                        mp.stop();
                    } else {
                        voice.setImageResource(R.drawable.music_on);
                        mp = new MediaPlayer().create(Story1_Detail.this, song[0]);
                        mp.start();
                    }
                    on = !on;
                }
            });

            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                public void onPageScrollStateChanged(int state) {

                }

                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                public void onPageSelected(final int position) {
                    mp.stop();
                    mp = new MediaPlayer().create(Story1_Detail.this, song[position]);
                    mp.start();
                    on = mp.isPlaying();
                    voice.setImageResource(R.drawable.music_on);
                    voice.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            if (on) {
                                voice.setImageResource(R.drawable.music_off);
                                mp.stop();
                            } else {
                                voice.setImageResource(R.drawable.music_on);
                                mp = new MediaPlayer().create(Story1_Detail.this, song[position]);
                                mp.start();
                            }
                            on = !on;
                        }
                    });
                }
            });

        }

        else if (data.equals("pos2")) {

            song = new  int[]{R.raw.elephant_1,R.raw.elephant_2, R.raw.elephant_3,
                    R.raw.elephant_4,R.raw.elephant_5, R.raw.elephant_6,  R.raw.elephant_7,
                    R.raw.elephant_8,  R.raw.elephant_9,R.raw.elephant_10,R.raw.elephant_11, R.raw.elephant_12};

            flag = new int[]{R.mipmap.e_1, R.mipmap.e_2,
                        R.mipmap.e_3, R.mipmap.e_4,
                        R.mipmap.e_5, R.mipmap.e_6, R.mipmap.e_7,
                        R.mipmap.e_8, R.mipmap.e_9, R.mipmap.e_10,
                        R.mipmap.e_11, R.mipmap.e_final, R.mipmap.e_final};

            i=0;
            query = "Select detail from story";
            Cursor cursor = helper.rawQuery(query);
            cursor.move(9);
            while (cursor.moveToNext()) {
                    if (i<12) {
                        String story_detail = cursor.getString(cursor.getColumnIndex("detail"));
                        str.add(story_detail);
                        i++;

                }
            }
            cursor.close();
            rank = (String[]) str.toArray(new String[str.size()]);

            mp = new MediaPlayer().create(Story1_Detail.this, song[0]);
            mp.start();
            on = mp.isPlaying();
            voice.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (on) {
                        voice.setImageResource(R.drawable.music_off);
                        mp.stop();
                    } else {
                        voice.setImageResource(R.drawable.music_on);
                        mp = new MediaPlayer().create(Story1_Detail.this, song[0]);
                        mp.start();
                    }
                    on = !on;
                }
            });

            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                public void onPageScrollStateChanged(int state) {

                }

                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                public void onPageSelected(final int position) {
                    mp.stop();
                    mp = new MediaPlayer().create(Story1_Detail.this, song[position]);
                    mp.start();
                    on = mp.isPlaying();
                    voice.setImageResource(R.drawable.music_on);
                    voice.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            if (on) {
                                voice.setImageResource(R.drawable.music_off);
                                mp.stop();
                            } else {
                                voice.setImageResource(R.drawable.music_on);
                                mp = new MediaPlayer().create(Story1_Detail.this, song[position]);
                                mp.start();
                            }
                            on = !on;
                        }
                    });
                }
            });

        }

            else if (data.equals("pos3")) {

            song = new  int[]{R.raw.lion_1,R.raw.lion_2, R.raw.lion_3,
                    R.raw.lion_4,R.raw.lion_5, R.raw.lion_6,  R.raw.lion_7,
                    R.raw.lion_8,  R.raw.lion_9,R.raw.lion_10,R.raw.lion_11, R.raw.lion_12};

            flag = new int[]{R.mipmap.lion_1, R.mipmap.lion_2_3,R.mipmap.lion_2_3, R.mipmap.lion_4,
                        R.mipmap.lion_5, R.mipmap.lion_6, R.mipmap.lion_7,
                        R.mipmap.lion_8, R.mipmap.lion_9_10, R.mipmap.lion_9_10,
                        R.mipmap.lion_11, R.mipmap.lion_final, R.mipmap.lion_final};

            i=0;
            query = "Select detail from story";
            Cursor cursor = helper.rawQuery(query);
            cursor.move(21);
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

            mp = new MediaPlayer().create(Story1_Detail.this, song[0]);
            mp.start();
            on = mp.isPlaying();
            voice.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (on) {
                        voice.setImageResource(R.drawable.music_off);
                        mp.stop();
                    } else {
                        voice.setImageResource(R.drawable.music_on);
                        mp = new MediaPlayer().create(Story1_Detail.this, song[0]);
                        mp.start();
                    }
                    on = !on;
                }
            });

            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                public void onPageScrollStateChanged(int state) {

                }

                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                public void onPageSelected(final int position) {
                    mp.stop();
                    mp = new MediaPlayer().create(Story1_Detail.this, song[position]);
                    mp.start();
                    on = mp.isPlaying();
                    voice.setImageResource(R.drawable.music_on);
                    voice.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            if (on) {
                                voice.setImageResource(R.drawable.music_off);
                                mp.stop();
                            } else {
                                voice.setImageResource(R.drawable.music_on);
                                mp = new MediaPlayer().create(Story1_Detail.this, song[position]);
                                mp.start();
                            }
                            on = !on;
                        }
                    });
                }
            });

        }

            else if (data.equals("pos4")) {

            song = new  int[]{R.raw.angel_1 , R.raw.angel_2,
                    R.raw.angel_3,R.raw.angel_4, R.raw.angel_5,  R.raw.angel_6, R.raw.angel_7,
                    R.raw.angel_8,  R.raw.angel_9,R.raw.angel_10,R.raw.angel_11, R.raw.angel_12, R.raw.angel_13,
                    R.raw.angel_14, R.raw.angel_15};


            flag = new int[]{R.mipmap.a_1, R.mipmap.a_2, R.mipmap.a_3,
                    R.mipmap.a_4, R.mipmap.a_5, R.mipmap.a_6,
                    R.mipmap.a_7,R.mipmap.a_8,R.mipmap.a_9, R.mipmap.a_10_11, R.mipmap.a_10_11,R.mipmap.a_12,R.mipmap.a_13,
                    R.mipmap.a_final,R.mipmap.a_final,R.drawable.ic_launcher};

            i=0;
            query = "Select detail from story";
            Cursor cursor = helper.rawQuery(query);
            cursor.move(33);
            while (cursor.moveToNext()) {
                if (i <15) {
                    String story_detail = cursor.getString(cursor.getColumnIndex("detail"));
                    str.add(story_detail);
                    i++;
                }
            }
            cursor.close();
            rank = (String[]) str.toArray(new String[str.size()]);

            mp = new MediaPlayer().create(Story1_Detail.this, song[0]);
            mp.start();
            on = mp.isPlaying();
            voice.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (on) {
                        voice.setImageResource(R.drawable.music_off);
                        mp.stop();
                    } else {
                        voice.setImageResource(R.drawable.music_on);
                        mp = new MediaPlayer().create(Story1_Detail.this, song[0]);
                        mp.start();
                    }
                    on = !on;
                }
            });

            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                public void onPageScrollStateChanged(int state) {

                }

                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                public void onPageSelected(final int position) {
                    mp.stop();
                    mp = new MediaPlayer().create(Story1_Detail.this, song[position]);
                    mp.start();
                    on = mp.isPlaying();
                    voice.setImageResource(R.drawable.music_on);
                    voice.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            if (on) {
                                voice.setImageResource(R.drawable.music_off);
                                mp.stop();
                            } else {
                                voice.setImageResource(R.drawable.music_on);
                                mp = new MediaPlayer().create(Story1_Detail.this, song[position]);
                                mp.start();
                            }
                            on = !on;
                        }
                    });
                }
            });
        }

            else if (data.equals("pos5")) {

            song = new  int[]{R.raw.moon_1,R.raw.moon_2, R.raw.moon_3,
                    R.raw.moon_4,R.raw.moon_5, R.raw.moon_6,  R.raw.moon_7,
                    R.raw.moon_8,  R.raw.moon_9,R.raw.moon_10};

            flag = new int[]{R.mipmap.s_1, R.mipmap.s_2,
                    R.mipmap.s_3, R.mipmap.s_4, R.mipmap.s_5, R.mipmap.s_6, R.mipmap.s_7, R.mipmap.s_8,
                    R.mipmap.s_9, R.mipmap.s_10,R.drawable.ic_launcher};

            i=0;
            query = "Select detail from story";
            Cursor cursor = helper.rawQuery(query);
            cursor.move(48);
            while (cursor.moveToNext()) {
                if (i <10) {
                    String story_detail = cursor.getString(cursor.getColumnIndex("detail"));
                    str.add(story_detail);
                    i++;
                }
            }
            cursor.close();
            rank = (String[]) str.toArray(new String[str.size()]);

            mp = new MediaPlayer().create(Story1_Detail.this, song[0]);
            mp.start();
            on = mp.isPlaying();
            voice.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (on) {
                        voice.setImageResource(R.drawable.music_off);
                        mp.stop();
                    } else {
                        voice.setImageResource(R.drawable.music_on);
                        mp = new MediaPlayer().create(Story1_Detail.this, song[0]);
                        mp.start();
                    }
                    on = !on;
                }
            });

            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                public void onPageScrollStateChanged(int state) {

                }

                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                public void onPageSelected(final int position) {
                    mp.stop();
                    mp = new MediaPlayer().create(Story1_Detail.this, song[position]);
                    mp.start();
                    on = mp.isPlaying();
                    voice.setImageResource(R.drawable.music_on);
                    voice.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            if (on) {
                                voice.setImageResource(R.drawable.music_off);
                                mp.stop();
                            } else {
                                voice.setImageResource(R.drawable.music_on);
                                mp = new MediaPlayer().create(Story1_Detail.this, song[position]);
                                mp.start();
                            }
                            on = !on;
                        }
                    });
                }
            });

        }


        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(getItem(+1),true);
            }
        });
//        backward.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewPager.setCurrentItem(getItem(-1),true);
//            }
//        });


        adapter = new Story1_ViewPageAdapter(Story1_Detail.this,rank, flag);

        viewPager.setAdapter(adapter);

        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mp.stop();
    }

    private int getItem(int i){
        return viewPager.getCurrentItem()+1;
    }

}

