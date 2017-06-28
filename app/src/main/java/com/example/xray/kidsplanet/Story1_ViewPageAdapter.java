package com.example.xray.kidsplanet;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class Story1_ViewPageAdapter extends PagerAdapter {

    Context context;
    String[] rank;
    int[] flag;
    LayoutInflater inflater;


    public Story1_ViewPageAdapter(Context context, String[] rank, int[] flag) {
        this.context = context;
        this.rank = rank;
        this.flag = flag;
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



        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.activity_story1__view_pager_adapter, container,
                false);


        txtrank = (TextView) itemView.findViewById(R.id.txtStory1);
        txtrank.setText(rank[position]);
        imgflag = (ImageView) itemView.findViewById(R.id.imgStory1);
        imgflag.setImageResource(flag[position]);

        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ((ViewPager) container).removeView(((LinearLayout) object));

    }
}
