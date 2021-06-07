package com.example.yummy;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    List<String> titles;
    List<Integer> images;
    LayoutInflater inflater;

    public Adapter(Context ctx, List<String> titles, List<Integer> images){

        this.titles = titles;
        this.images = images;
        this.inflater = LayoutInflater.from(ctx);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.activity_user_screen,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.title.setText(titles.get(position));
        holder.gridIcon.setImageResource(images.get(position));

    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        TextView title;
        ImageView gridIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            gridIcon = itemView.findViewById(R.id.im_of_dish);

        }

    }

}
