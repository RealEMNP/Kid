package com.example.xray.kidsplanet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;


public class EducationLayout extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_layout);
        getSupportActionBar().hide();

        ImageButton btn1,btn2,btn3,btn4,btn5,back;
        btn1 = (ImageButton) findViewById(R.id.img_btn1);
        btn2 = (ImageButton) findViewById(R.id.img_btn2);
//        btn3 = (ImageButton) findViewById(R.id.img_btn3);
//        btn4 = (ImageButton) findViewById(R.id.img_btn4);
//        btn5 = (ImageButton) findViewById(R.id.img_btn5);
        back = (ImageButton) findViewById(R.id.img_btnBackEdu);

        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent= new Intent(EducationLayout.this, EducationGridView1.class);
                intent.putExtra("btn","eng_123");
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), EducationGridView1.class);
                intent.putExtra("btn","abc");
                startActivity(intent);
            }
        });
//        btn3.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        btn4.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                Intent intent= new Intent(getApplicationContext(), EducationGridView1.class);
//                intent.putExtra("btn","mm_123");
//                startActivity(intent);
//            }
//        });
//        btn5.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                Intent intent= new Intent(getApplicationContext(), EducationGridView1.class);
//                intent.putExtra("btn","ka_kha_ga");
//                startActivity(intent);
//            }
//        });
        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });
}
}