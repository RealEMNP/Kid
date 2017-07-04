package com.example.xray.kidsplanet;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Telephony;
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
import android.webkit.WebView;
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
        final Button btnAboutUs;
        final Button btnRate;

        back = (ImageButton) findViewById(R.id.back);
        btnRate = (Button) findViewById(R.id.web_Rate);
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
                Intent intent = new Intent(getApplicationContext(), RateUs.class);
                startActivity(intent);
            }
        });
        btnAboutUs.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                alertDialogBuilder = new AlertDialog.Builder(Setting.this);
                alertDialogBuilder.setMessage("\t\t\t\t"+"Developed by:" + "\n\n\t\t\t\t\t\t\t\t" + "X-Ray" + "\n\n"+
                        "Computer University Taungoo" + "\n\n\t\t\t\t\t\t\t" + "Version 1.0"+"\n\n"+"Credit to: Original Uploader");

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
                lp.height = 750;
//                lp.x = 170;
//                lp.y = 100;
                alertDialog.getWindow().setAttributes(lp);
            }

        });


    }

}