package com.example.xray.kidsplanet;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import mm.technomation.mmtext.mmtext;


public class Poem1Detail extends AppCompatActivity {
    boolean on = true;
    String query;
    String data;
    String poem_detail;
    private  static final String DB_Name = "kid.db";
    DataBaseHelper helper ;
    MediaPlayer mp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poem1_detail);
        getSupportActionBar().hide();



        helper = DataBaseHelper.getInstance(this, DB_Name);

        final ImageButton back, home , voice;
        TextView txt1 ;
        ImageView imageView;


        back = (ImageButton) findViewById(R.id.img_btnBackPoem1);
        home = (ImageButton) findViewById(R.id.img_btnPoem1toHome);
        voice = (ImageButton) findViewById(R.id.img_btnPoem1On);
        txt1 = (TextView) findViewById(R.id.txtPoem1);
        imageView = (ImageView) findViewById(R.id.img_poem);
        Bundle extras=getIntent().getExtras();
        data=extras.getString("st1");

        if(data.equals("pos1")){
            query = "Select detail from poem where poem_ID='p1'";
            Cursor cursor = DataBaseHelper.rawQuery(query);

                if (cursor.moveToFirst()) {
                  poem_detail=cursor.getString(cursor.getColumnIndex("detail"));
                }

            txt1.setText(poem_detail);

            txt1.setTextColor(Color.BLACK);
            imageView.setImageResource(R.mipmap.sone_oak_ni_ni);

            mp = new MediaPlayer().create(this, R.raw.sone_oak_ni_ni);
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
                        mp = new MediaPlayer().create(Poem1Detail.this, R.raw.sone_oak_ni_ni);
                        mp.start();
                    }
                    on = !on;
                }
            });
        }

        if(data.equals("pos2")){
            query = "Select detail from poem where poem_ID='p2'";
            Cursor cursor = DataBaseHelper.rawQuery(query);

            if (cursor.moveToFirst()) {
                poem_detail=cursor.getString(cursor.getColumnIndex("detail"));
            }

            txt1.setText(poem_detail);
            txt1.setTextColor(Color.BLACK);
            imageView.setImageResource(R.mipmap.totoyaywar);

            mp = new MediaPlayer().create(this, R.raw.tu_tu_yay_war);
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
                        mp = new MediaPlayer().create(Poem1Detail.this, R.raw.tu_tu_yay_war);
                        mp.start();
                    }
                    on = !on;
                }
            });
        }
         if(data.equals("pos3")){
            query = "Select detail from poem where poem_ID='p3'";
            Cursor cursor = DataBaseHelper.rawQuery(query);

            if (cursor.moveToFirst()) {
                poem_detail=cursor.getString(cursor.getColumnIndex("detail"));
            }
            txt1.setText(poem_detail);
            txt1.setTextColor(Color.BLACK);
             imageView.setImageResource(R.mipmap.parrot);

            mp = new MediaPlayer().create(this, R.raw.parrot);
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
                        mp = new MediaPlayer().create(Poem1Detail.this, R.raw.parrot);
                        mp.start();
                    }
                    on = !on;
                }
            });
        }
        if(data.equals("pos4")){
            query = "Select detail from poem where poem_ID='p4'";
            Cursor cursor = DataBaseHelper.rawQuery(query);

            if (cursor.moveToFirst()) {
                poem_detail=cursor.getString(cursor.getColumnIndex("detail"));
            }
            txt1.setText(poem_detail);
            txt1.setTextColor(Color.BLACK);
            imageView.setImageResource(R.mipmap.kyat_pha_tain_nyine);

            mp = new MediaPlayer().create(this, R.raw.kyat_pha_tane_nyin);
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
                        mp = new MediaPlayer().create(Poem1Detail.this, R.raw.kyat_pha_tane_nyin);
                        mp.start();
                    }
                    on = !on;
                }
            });
        }
        if(data.equals("pos5")){
            query = "Select detail from poem where poem_ID='p5'";
            Cursor cursor = DataBaseHelper.rawQuery(query);

            if (cursor.moveToFirst()) {
                poem_detail=cursor.getString(cursor.getColumnIndex("detail"));
            }
            txt1.setText(poem_detail);
            txt1.setTextColor(Color.BLACK);
            imageView.setImageResource(R.mipmap.lal_sount_tae);

            mp = new MediaPlayer().create(this, R.raw.lal_sont_tal);
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
                        mp = new MediaPlayer().create(Poem1Detail.this, R.raw.lal_sont_tal);
                        mp.start();
                    }
                    on = !on;
                }
            });
        }
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
                Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                mp.stop();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mp.stop();
    }
}
