package com.example.yummy;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

    Context context;
    String[] dishName;
    int[] image;
    String[] descriptions;

    LayoutInflater inflater;


    public GridAdapter(Context context, String[] dishName, int[] image, String[] descriptions) {
        this.context = context;
        this.dishName = dishName;
        this.image = image;
        this.descriptions = descriptions;



    }

    @Override
    public int getCount() {
        return dishName.length;
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

        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.grid_item, null);

        }

        ImageView imageView = convertView.findViewById(R.id.im_of_dish);
        TextView textView = convertView.findViewById(R.id.title);
        TextView textView1 = convertView.findViewById(R.id.des);

        imageView.setImageResource(image[position]);
        textView.setText(dishName[position]);
        textView1.setText(descriptions[position]);


        return convertView;

    }
}