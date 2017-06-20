
package com.example.xray.kidsplanet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


public class EducationGridView1 extends AppCompatActivity {
    boolean on = true;
    int count = 0;

    static final int image[] = {R.drawable.one , R.drawable.two , R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six,
            R.drawable.seven, R.drawable.eight, R.drawable.nine};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_grid_view1);
        getSupportActionBar().hide();


        final ImageButton back, home , voice , backward ,forward;


        final ImageView imgview = (ImageView) findViewById(R.id.imgEduGVD1);
        back = (ImageButton) findViewById(R.id.img_btnBackEduGVD1);
        home = (ImageButton) findViewById(R.id.img_btnEduGVD1toHome);
        voice = (ImageButton) findViewById(R.id.img_btnEduGVD1On);
        forward = (ImageButton) findViewById(R.id.img_btnForward);
        backward = (ImageButton) findViewById(R.id.img_btnBackward);



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


        imgview.setImageResource(image[0]);

        forward.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                backward.setVisibility(View.VISIBLE);
            if(count<image.length-1){
                ++count;
                imgview.setImageResource(image[count]);
            }
            else {
                imgview.setImageResource(image[0]);
            }
            }
        });
        backward.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(count<image.length-1){
                    --count;
                    if(count == 0) {
                        backward.setVisibility(View.INVISIBLE);
                        imgview.setImageResource(image[count]);
                    }
                    else imgview.setImageResource(image[count]);
                }
            }
        });

    }
}

