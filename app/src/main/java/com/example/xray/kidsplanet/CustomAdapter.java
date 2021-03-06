package com.example.xray.kidsplanet;

/**
 * Created by User on 10/1/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
public class CustomAdapter extends BaseAdapter {
    Context context;
    int images[];
    LayoutInflater inflter;
    public CustomAdapter(Context applicationContext, int[] images) {
        this.context = applicationContext;
        this.images = images;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return images.length;
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_paint_picture_gridview, null); // inflate the layout
        ImageView icon = (ImageView) view.findViewById(R.id.icon); // get the reference of ImageView
        icon.setImageResource(images[i]); // set logo images
        return view;
    }
}


