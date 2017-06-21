package com.example.xray.kidsplanet;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class Poem1Detail extends AppCompatActivity {
    boolean on = true;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poem1_detail);
        getSupportActionBar().hide();

        final ImageButton back, home , voice;
        TextView txt1;
        back = (ImageButton) findViewById(R.id.img_btnBackPoem1);
        home = (ImageButton) findViewById(R.id.img_btnPoem1toHome);
        voice = (ImageButton) findViewById(R.id.img_btnPoem1On);
        txt1 = (TextView) findViewById(R.id.txtPoem1);
        Bundle extras=getIntent().getExtras();
        String data=extras.getString("st1");

        if(data.equals("pos1")){
            txt1.setText("Position2");
        }if(data.equals("pos2")){
            txt1.setText("Position2");
        }if(data.equals("pos3")){
            txt1.setText("Position3");
        }if(data.equals("pos4")){
            txt1.setText("Position4");
        }if(data.equals("pos5")){
            txt1.setText("Position5");
        }

        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        voice.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(on)
                 voice.setImageResource(R.drawable.ic_volume_off_black_24dp);
                else
                    voice.setImageResource(R.drawable.ic_volume_up_black_24dp);
                on = !on;
            }
        });
    }
}
