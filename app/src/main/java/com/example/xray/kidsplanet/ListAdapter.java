package com.example.xray.kidsplanet;

/**
 * Created by User on 10/2/2017.
 */

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by hp on 9/29/2017.
 */

public class ListAdapter extends ArrayAdapter<String> {
    Context context;
    List letterArray;
    String listtype;
    public ListAdapter(@NonNull Context context, @LayoutRes int resource, List letterArray,String listtype) {
        super(context, resource);
        this.context = context;
        this.letterArray = letterArray;
        this.listtype=listtype;
    }

    @Override
    public int getCount() {
        return letterArray.size();
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater li = LayoutInflater.from(context);
        convertView = li.inflate(R.layout.activity_match_list_view, parent, false);
        final TextView letter = (TextView) convertView.findViewById(R.id.letter_list_item);
        if(listtype.equals("second"))
            letter.setText(letterArray.get(position).toString().toLowerCase());
        else
            letter.setText(letterArray.get(position).toString().toUpperCase());
        return convertView;

    }
}


