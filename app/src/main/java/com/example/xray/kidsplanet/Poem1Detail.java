package com.example.xray.kidsplanet;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class Poem1Detail extends AppCompatActivity {
    boolean on = true;
    String query;
    String data;
    private  static final String DB_Name = "database.db";
    DataBaseHelper helper ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poem1_detail);
        getSupportActionBar().hide();

        helper = DataBaseHelper.getInstance(this, DB_Name);

        final ImageButton back, home , voice;
        TextView txt1;
        back = (ImageButton) findViewById(R.id.img_btnBackPoem1);
        home = (ImageButton) findViewById(R.id.img_btnPoem1toHome);
        voice = (ImageButton) findViewById(R.id.img_btnPoem1On);
        txt1 = (TextView) findViewById(R.id.txtPoem1);
        Bundle extras=getIntent().getExtras();
        data=extras.getString("st1");

        if(data.equals("pos1")){
            query = "Select detail from poem where poemID = 'p1'";
            Cursor cursor = DataBaseHelper.rawQuery(query);
            //if(cursor != null && cursor.getCount() != 0) {
                Toast.makeText(getBaseContext(),cursor.getString(cursor.getColumnIndex("detail")),Toast.LENGTH_SHORT).show();
                //if (cursor.moveToFirst()) {

                     //       txt1.setText(cursor.getString(cursor.getColumnIndex("detail")));

                    //}
                //}
            }


        if(data.equals("pos2")){
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
                 voice.setImageResource(R.drawable.voice_off);
                else
                    voice.setImageResource(R.drawable.voice_on);
                on = !on;
            }
        });
    }
}
