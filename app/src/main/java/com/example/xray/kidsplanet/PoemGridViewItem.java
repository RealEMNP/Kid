package com.example.xray.kidsplanet;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import mm.technomation.mmtext.mmtext;


public class PoemGridViewItem extends BaseAdapter {


    private Context mContext;
    public  String[] poem;
    private  int[] image;



    public PoemGridViewItem(Context c, String[] poem, int[] image){
        mContext=c;
        this.image=image;
        this.poem=poem;
    }

    public PoemGridViewItem(String[] poem, int[] image) {
        this.poem = poem;
        this.image = image;
    }

    public PoemGridViewItem() {
    }

    @Override
    public int getCount() {
        return poem.length;
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
            grid= new View(mContext);
            grid=inflater.inflate(R.layout.activity_poem_grid_view_item,null);
            TextView textView= (TextView) grid.findViewById(R.id.poem_grid_text);
            ImageView imageView= (ImageView) grid.findViewById(R.id.poem_grid_image);
            textView.setText(poem[position]);
            imageView.setImageResource(image[position]);
        mmtext.prepareViewGroup(this.mContext,(ViewGroup) grid,mmtext.TEXT_UNICODE,true,false);

        return  grid;
    }
}
