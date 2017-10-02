package com.example.xray.kidsplanet;

/**
 * Created by User on 10/2/2017.
 */

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import android.os.Handler;

public class MatchingActivity extends AppCompatActivity {
    String first_array[] = {"", "", "", "", ""},
            second_array[] = {"", "", "", "", ""};
    String temp;
    ImageButton back;
    int j = 0;
    int flag=0;
    ListAdapter listAdapter_for_first, listAdapter_for_second;
    String txt_first = "", txt_second = "";
    List<String> first_list, second_list;
    int first_index, second_index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final ListView firstList = (ListView) findViewById(R.id.firstList);
        final ListView secondList = (ListView) findViewById(R.id.secondList);
        back = (ImageButton) findViewById(R.id.img_btnBack);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Random random = new Random();
        for (int i = 0; i < 5; i++)
            first_array[i] = String.valueOf((char) (random.nextInt(26) + 'a'));
        first_list = new ArrayList<>(Arrays.asList(first_array));
        listAdapter_for_first = new ListAdapter(this, R.layout.activity_match_list_view, first_list, "first");
        firstList.setAdapter(listAdapter_for_first);
        for (int i = 0; i < 5; i++) {
            temp = first_array[random.nextInt(first_array.length)];
            while (j < i) {
                if (temp == second_array[j]) {
                    temp = first_array[random.nextInt(first_array.length)];
                    j = 0;
                } else j++;
            }
            j = 0;
            second_array[i] = temp;
        }

        second_list = new ArrayList<>(Arrays.asList(second_array));
        listAdapter_for_second = new ListAdapter(this, R.layout.activity_match_list_view, second_list, "second");
        secondList.setAdapter(listAdapter_for_second);

        //Check Equal
        firstList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                firstList.setSelector(R.color.colorPrimary);
                listAdapter_for_first.notifyDataSetChanged();
                txt_first = first_list.get(position);
                first_index = position;
                if (txt_first.equals(txt_second)) {
                    firstList.setSelector(R.color.colorTrue);
                    secondList.setSelector(R.color.colorTrue);
                    listAdapter_for_second.notifyDataSetChanged();
                    firstList.setEnabled(false);
                    secondList.setEnabled(false);
                    new CountDownTimer(1000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }
                        @Override
                        public void onFinish() {
                            first_list.remove(first_index);
                            second_list.remove(second_index);
                            firstList.setSelector(R.color.colorTranparent);
                            secondList.setSelector(R.color.colorTranparent);
                            listAdapter_for_first.notifyDataSetChanged();
                            listAdapter_for_second.notifyDataSetChanged();
                            firstList.clearFocus();
                            secondList.clearFocus();
                            txt_first = "";
                            txt_second = "";
                            firstList.setEnabled(true);
                            secondList.setEnabled(true);
                        }
                    }.start();

                } else if (!txt_second.equals("")) {
                    firstList.setSelector(R.color.colorAccent);
                    secondList.setSelector(R.color.colorAccent);
                    listAdapter_for_second.notifyDataSetChanged();
                    firstList.setEnabled(false);
                    secondList.setEnabled(false);
                    new CountDownTimer(1000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                        }

                        @Override
                        public void onFinish() {
                            txt_first = "";
                            txt_second = "";
                            firstList.clearFocus();
                            secondList.clearFocus();
                            firstList.setSelector(R.color.colorTranparent);
                            secondList.setSelector(R.color.colorTranparent);
                            listAdapter_for_first.notifyDataSetChanged();
                            listAdapter_for_second.notifyDataSetChanged();
                            firstList.setEnabled(true);
                            secondList.setEnabled(true);
                        }
                    }.start();


                }

            }



        });
        secondList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                secondList.setSelector(R.color.colorPrimary);
                listAdapter_for_second.notifyDataSetChanged();
                txt_second = second_list.get(position);
                second_index = position;
                if (txt_first.equals(txt_second)) {
                    firstList.setSelector(R.color.colorTrue);
                    secondList.setSelector(R.color.colorTrue);
                    listAdapter_for_first.notifyDataSetChanged();
                    firstList.setEnabled(false);
                    secondList.setEnabled(false);
                    new CountDownTimer(1000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                        }

                        @Override
                        public void onFinish() {
                            first_list.remove(first_index);
                            second_list.remove(second_index);
                            firstList.setSelector(R.color.colorTranparent);
                            secondList.setSelector(R.color.colorTranparent);
                            listAdapter_for_first.notifyDataSetChanged();
                            listAdapter_for_second.notifyDataSetChanged();
                            firstList.clearFocus();
                            secondList.clearFocus();
                            txt_first = "";
                            txt_second = "";
                            firstList.setEnabled(true);
                            secondList.setEnabled(true);
                        }
                    }.start();

                } else if (!txt_first.equals("")) {
                    firstList.setSelector(R.color.colorAccent);
                    secondList.setSelector(R.color.colorAccent);
                    listAdapter_for_first.notifyDataSetChanged();
                    firstList.setEnabled(false);
                    secondList.setEnabled(false);
                    new CountDownTimer(1000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                        }

                        @Override
                        public void onFinish() {
                            txt_first = "";
                            txt_second = "";
                            firstList.clearFocus();
                            secondList.clearFocus();
                            firstList.setSelector(R.color.colorTranparent);
                            secondList.setSelector(R.color.colorTranparent);
                            listAdapter_for_first.notifyDataSetChanged();
                            listAdapter_for_second.notifyDataSetChanged();
                            firstList.setEnabled(true);
                            secondList.setEnabled(true);
                        }
                    }.start();


                }

            }



        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

