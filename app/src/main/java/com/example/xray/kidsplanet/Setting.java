package com.example.xray.kidsplanet;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import static android.R.attr.button;

public class Setting extends AppCompatActivity {
    private PopupWindow mPopWindow;
    AlertDialog.Builder alertDialogBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ImageButton back;
        Button btnRate ,btnAboutUs;

        back = (ImageButton) findViewById(R.id.back);
        btnRate = (Button) findViewById(R.id.btnRate);
        btnAboutUs = (Button) findViewById(R.id.btnAboutUs);

        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnRate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });
        btnAboutUs.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                alertDialogBuilder = new AlertDialog.Builder(Setting.this);
                alertDialogBuilder.setMessage("Desingned & developed by" + "\n\t\t\t\t\t\t\t\t" + "X-Ray" + "\n"+
                        "Computer University Taungoo" + "\n\t\t\t\t\t\t\t" + "Version 1.0");

//                alertDialogBuilder.setPositiveButton("yes",
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface arg0, int arg1) {
//                                Toast.makeText(Setting.this, "You clicked yes button", Toast.LENGTH_LONG).show();
//                            }
//                        });
//
//                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//
//                    public void onClick(DialogInterface dialog, int which) {
//                        finish();
//                    }
//                });


                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(alertDialog.getWindow().getAttributes());
                lp.width = 800;
                lp.height = 450;
//                lp.x = 170;
//                lp.y = 100;
                alertDialog.getWindow().setAttributes(lp);
            }

        });


    }

}