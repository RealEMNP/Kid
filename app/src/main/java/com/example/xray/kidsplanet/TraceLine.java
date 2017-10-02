package com.example.xray.kidsplanet;

/**
 * Created by User on 10/1/2017.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.gesture.GestureOverlayView;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

public class TraceLine extends Activity {

    private GestureOverlayView gesture;
    ImageView imageView;
    ImageButton nextButton, previousButton;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_trace_line);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final int image[] = {R.drawable.circle, R.drawable.star, R.drawable.triangle, R.drawable.m1, R.drawable.m2, R.drawable.m3,
                R.drawable.m4, R.drawable.m5, R.drawable.m6};

        gesture = (GestureOverlayView) findViewById(R.id.gestures);
        imageView = (ImageView) findViewById(R.id.imgView);
        nextButton = (ImageButton) findViewById(R.id.imgbtn_next);
        previousButton = (ImageButton) findViewById(R.id.imgbtn_previous);

        imageView.setImageResource(image[0]);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousButton.setVisibility(View.VISIBLE);
                if(count == 7){
                    nextButton.setVisibility(View.INVISIBLE);
                }

                if(count<image.length-1){
                    ++count;
                    imageView.setImageResource(image[count]);
                }
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                --count;
                if(count == 0) {
                    previousButton.setVisibility(View.INVISIBLE);
                    nextButton.setVisibility(View.VISIBLE);
                    imageView.setImageResource(image[count]);
                }
                else {
                    imageView.setImageResource(image[count]);
                    nextButton.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);

        switch (action){
            case (MotionEvent.ACTION_DOWN): return true;
            case (MotionEvent.ACTION_MOVE): return true;
            case (MotionEvent.ACTION_UP): return true;
            case (MotionEvent.ACTION_CANCEL): return true;
            case  (MotionEvent.ACTION_OUTSIDE):return true;
            default: super.onTouchEvent(event);
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
