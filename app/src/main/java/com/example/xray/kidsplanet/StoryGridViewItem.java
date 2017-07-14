package com.example.xray.kidsplanet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import mm.technomation.mmtext.mmtext;

import static com.example.xray.kidsplanet.R.layout.activity_story_grid_view_item;


public class StoryGridViewItem extends BaseAdapter{
    private Context mContext;
    private final String[] story;
    private final int[] image;



    public StoryGridViewItem(Context c, String[] story, int[] image){
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
//        if(convertView== null){
            grid= new View(mContext);
            grid=inflater.inflate(activity_story_grid_view_item,null);
            TextView textView= (TextView) grid.findViewById(R.id.story_grid_text);
            ImageView imageView= (ImageView) grid.findViewById(R.id.story_grid_image);
            textView.setText(story[position]);
            imageView.setImageResource(image[position]);
//        }
//        else {
//            grid = (View) convertView;
//        }

        mmtext.prepareViewGroup(this.mContext,(ViewGroup) grid,mmtext.TEXT_UNICODE,true,false);

        return  grid;
    }


}