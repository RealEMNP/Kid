package com.example.xray.kidsplanet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class PoemGridViewItem extends BaseAdapter {
    private Context mContext;
    private final String[] story;
    private final int[] image;

    public PoemGridViewItem(Context c, String[] story, int[] image){
        mContext=c;
        this.image=image;
        this.story=story;
    }

    @Override
    public int getCount() {
        return story.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView== null){
            grid= new View(mContext);
            grid=inflater.inflate(R.layout.activity_poem_grid_view_item,null);
            TextView textView= (TextView) grid.findViewById(R.id.poem_grid_text);
            ImageView imageView= (ImageView) grid.findViewById(R.id.poem_grid_image);
            textView.setText(story[position]);
            imageView.setImageResource(R.drawable.untitled3);
        }
        else {
            grid = (View) convertView;
        }
        return  grid;
    }
}
