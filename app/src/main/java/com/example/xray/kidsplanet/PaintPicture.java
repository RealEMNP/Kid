package com.example.xray.kidsplanet;

/**
 * Created by User on 10/1/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;


public class PaintPicture extends AppCompatActivity {
    GridView simpleGrid;
    ImageButton btnBack;
    int images[] = {R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5, R.drawable.p6, R.drawable.p7, R.drawable.p8,
            R.drawable.p9, R.drawable.p10, R.drawable.p11, R.drawable.p12, R.drawable.p13, R.drawable.p14, R.drawable.p15};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint_picture);
        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnBack = (ImageButton) findViewById(R.id.img_btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        simpleGrid = (GridView) findViewById(R.id.simpleGridView); 
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), images);
        simpleGrid.setAdapter(customAdapter);
        simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
                Intent intent = new Intent(PaintPicture.this, PaintActivity.class);
                intent.putExtra("image", position);
                startActivity(intent); 
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
