package com.example.xray.kidsplanet;

/**
 * Created by User on 10/1/2017.
 */

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Queue;


public class PaintActivity extends Activity implements View.OnTouchListener {
    private RelativeLayout drawingLayout;
    private MyView myView;
    Button red, blue, yellow, gray, black, dkGray, magenta, lime, pink, hotPink, deepPink, pearl, pinkBubblegum, purple, brown,
            green, cyan, maroon, olive, lightBlue;
    ImageButton btnNext, btnBack, btnHome;
    Paint paint;
    Bitmap mBitmap;
    int[] images = {R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5, R.drawable.p6, R.drawable.p7, R.drawable.p8,
            R.drawable.p9, R.drawable.p10, R.drawable.p11, R.drawable.p12, R.drawable.p13, R.drawable.p14, R.drawable.p15};
    int i =0;
    int j;
    int data;

    /**
     * Called when the activity is first created.
     */
/*
 *
 * private ImageView imageView; private Canvas cv; private Bitmap mask,
 * original, colored; private int r,g,b; private int sG, sR, sB;
 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        myView = new MyView(this);
        drawingLayout = (RelativeLayout) findViewById(R.id.relative_layout);
        drawingLayout.addView(myView);

        btnNext = (ImageButton) findViewById(R.id.btnNext);
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnHome = (ImageButton) findViewById(R.id.btnHome);

        Bundle extras = getIntent().getExtras();
        data = extras.getInt("image");

        i = data;
        if (i<15){
            myView.CallImageBitmap(images[i]);
            drawingLayout.removeAllViews();
            drawingLayout.addView(myView);
            i++;
        }

        red = (Button) findViewById(R.id.btn_red);
        blue = (Button) findViewById(R.id.btn_blue);
        yellow = (Button) findViewById(R.id.btn_yellow);
        gray = (Button) findViewById(R.id.btn_gray);
        black = (Button) findViewById(R.id.btn_black);
        dkGray = (Button) findViewById(R.id.btn_dkGray);
        magenta = (Button) findViewById(R.id.btn_magenta);
        lime = (Button) findViewById(R.id.btn_lime);
        pink = (Button) findViewById(R.id.btn_pink);
        hotPink = (Button) findViewById(R.id.btn_hotPink);
        deepPink = (Button) findViewById(R.id.btn_deepPink);
        pearl = (Button) findViewById(R.id.btn_pearl);
        pinkBubblegum = (Button) findViewById(R.id.btn_pinkBubblegum);
        purple = (Button) findViewById(R.id.btn_purple);
        brown = (Button) findViewById(R.id.btn_brown);
        green = (Button) findViewById(R.id.btn_green);
        cyan = (Button) findViewById(R.id.btn_cyan);
        maroon = (Button) findViewById(R.id.btn_maroon);
        olive = (Button) findViewById(R.id.btn_olive);
        lightBlue = (Button) findViewById(R.id.btn_lightBlue);

        red.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                paint.setColor(Color.RED);
            }
        });
        yellow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                paint.setColor(Color.YELLOW);
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                paint.setColor(Color.BLUE);
            }
        });
        gray.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                paint.setColor(Color.GRAY);
            }
        });
        black.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                paint.setColor(Color.BLACK);
            }
        });
        dkGray.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                paint.setColor(Color.DKGRAY);
            }
        });
        magenta.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                paint.setColor(Color.MAGENTA);
            }
        });
        lime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {paint.setColor(Color.parseColor("#00FF00"));
            }
        });
        pink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {paint.setColor(Color.parseColor("#FAAFBE"));
            }
        });
        hotPink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {paint.setColor(Color.parseColor("#F660AB"));
            }
        });
        hotPink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {paint.setColor(Color.parseColor("#F660AB"));
            }
        });
        deepPink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {paint.setColor(Color.parseColor("#F52887"));
            }
        });
        pearl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {paint.setColor(Color.parseColor("#FDEEFA"));
            }
        });
        pinkBubblegum.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {paint.setColor(Color.parseColor("#FFDFDD"));
            }
        });
        purple.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {paint.setColor(Color.parseColor("#800080"));
            }
        });
        brown.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {paint.setColor(Color.parseColor("#A52A2A"));
            }
        });
        green.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {paint.setColor(Color.parseColor("#008000"));
            }
        });
        cyan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {paint.setColor(Color.parseColor("#FF00FFFF"));
            }
        });
        maroon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {paint.setColor(Color.parseColor("#800000"));
            }
        });
        olive.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {paint.setColor(Color.parseColor("#808000"));
            }
        });
        lightBlue.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {paint.setColor(Color.parseColor("#ADD8E6"));

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i<15) {
                    myView.CallImageBitmap(images[i]);
                    drawingLayout.removeAllViews();
                    drawingLayout.addView(myView);
                    i++;
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });



    }


    public class MyView extends View {

        private Path path;
        ProgressDialog pd;
        final Point p1 = new Point();
        Canvas canvas;


        public MyView(PaintActivity context) {
            super(context);
            paint = new Paint();
            paint.setAntiAlias(true);
            pd = new ProgressDialog(context);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setStrokeWidth(5f);
            CallImageBitmap(images[i]);
            this.path = new Path();

        }

        public  void CallImageBitmap(int img) {
            mBitmap = BitmapFactory.decodeResource(getResources(),
                    img).copy(Bitmap.Config.ARGB_8888, true);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            this.canvas = canvas;
            paint.setColor(Color.WHITE);
            canvas.drawBitmap(mBitmap, 0, 0, paint);

        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();
            float y = event.getY();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:

                    p1.x = (int) x;
                    p1.y = (int) y;
                    final int sourceColor = mBitmap.getPixel((int) x, (int) y);
                    final int targetColor = paint.getColor();
                    new TheTask(mBitmap, p1, sourceColor, targetColor).execute();
                    invalidate();
            }
            return true;
        }

        public void clear() {
            path.reset();
            invalidate();
        }

        public int getCurrentPaintColor() {
            return paint.getColor();
        }

        class TheTask extends AsyncTask<Void, Integer, Void> {

            Bitmap bmp;
            Point pt;
            int replacementColor, targetColor;

            public TheTask(Bitmap bm, Point p, int sc, int tc) {
                this.bmp = bm;
                this.pt = p;
                this.replacementColor = tc;
                this.targetColor = sc;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {

            }

            @Override
            protected Void doInBackground(Void... params) {
                FloodFill f = new FloodFill();
                f.floodFill(bmp, pt, targetColor, replacementColor);
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                pd.dismiss();
                invalidate();
            }
        }
    }

    public class FloodFill {
        public void floodFill(Bitmap image, Point node, int targetColor,
                              int replacementColor) {
            int width = image.getWidth();
            int height = image.getHeight();
            int target = targetColor;
            int replacement = replacementColor;
            if (target != replacement) {
                Queue<Point> queue = new LinkedList<Point>();
                do {

                    int x = node.x;
                    int y = node.y;
                    while (x > 0 && image.getPixel(x - 1, y) == target) {
                        x--;

                    }
                    boolean spanUp = false;
                    boolean spanDown = false;
                    while (x < width && image.getPixel(x, y) == target) {
                        image.setPixel(x, y, replacement);
                        if (!spanUp && y > 0
                                && image.getPixel(x, y - 1) == target) {
                            queue.add(new Point(x, y - 1));
                            spanUp = true;
                        } else if (spanUp && y > 0
                                && image.getPixel(x, y - 1) != target) {
                            spanUp = false;
                        }
                        if (!spanDown && y < height - 1
                                && image.getPixel(x, y + 1) == target) {
                            queue.add(new Point(x, y + 1));
                            spanDown = true;
                        } else if (spanDown && y < height - 1
                                && image.getPixel(x, y + 1) != target) {
                            spanDown = false;
                        }
                        x++;
                    }
                } while ((node = queue.poll()) != null);
            }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

