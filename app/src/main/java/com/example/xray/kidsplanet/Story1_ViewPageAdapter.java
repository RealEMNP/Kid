package com.example.xray.kidsplanet;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class Story1_ViewPageAdapter extends PagerAdapter {

    Context context;
    String[] rank;
    int[] flag;
//    int[] song;
    LayoutInflater inflater;


    public Story1_ViewPageAdapter(Context context, String[] rank, int[] flag) {
        this.context = context;
        this.rank = rank;
        this.flag = flag;
//        this.song = song;
    }

    @Override
    public int getCount() {
        return rank.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // Declare Variables
        TextView txtrank;
        ImageView imgflag;
//        ImageButton img_song;




        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.activity_story1__view_pager_adapter, container,
                false);


        txtrank = (TextView) itemView.findViewById(R.id.txtStory1);
        txtrank.setText(rank[position]);
        imgflag = (ImageView) itemView.findViewById(R.id.imgStory1);
        imgflag.setImageResource(flag[position]);
//        img_song = (ImageButton) itemView.findViewById(R.id.img_btnStory1On);



        ((ViewPager) container).addView(itemView);

//        LinearLayout ll = (LinearLayout)itemView.findViewById(R.id.lin_viewpager);
//        ImageButton newButton = new ImageButton(context);
//        newButton.setImageResource(R.drawable.voice_on);
//        ll.addView(newButton);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ((ViewPager) container).removeView(((LinearLayout) object));

    }
}
