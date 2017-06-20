package com.example.xray.kidsplanet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class Story1Detail extends AppCompatActivity {
    boolean on = true;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story1_detail);
        getSupportActionBar().hide();

        final ImageButton back , home ,voice;
        final TextView txt1;
        back = (ImageButton) findViewById(R.id.img_btnBackStory1);
        home = (ImageButton) findViewById(R.id.img_btnStory1toHome);
        voice = (ImageButton) findViewById(R.id.img_btnStory1On);
        txt1 = (TextView) findViewById(R.id.txtStory1);

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
                    voice.setImageResource(R.drawable.ic_volume_off_black_24dp);
                else
                    voice.setImageResource(R.drawable.ic_volume_up_black_24dp);
                on = !on;
            }
        });

    }
}
