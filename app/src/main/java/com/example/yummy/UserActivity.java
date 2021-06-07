package com.example.yummy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class UserActivity extends AppCompatActivity {

    RecyclerView rv_grid;
    List<String> titles;
    List<Integer> images;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_screen);
        rv_grid = findViewById(R.id.rv_grid);

        titles = new ArrayList<>();
        images = new ArrayList<>();

        titles.add("First Item");
        titles.add("Second Item");
        titles.add("Third Item");
        titles.add("Fourth Item");

        images.add(R.drawable.ciasto_gora_lodowa);
        images.add(R.drawable.czekolada_na_goraco_na_czerwonym_winie);
        images.add(R.drawable.dorsz_w_sosie_curry);
        images.add(R.drawable.sernik_swiateczny_z_brzoskwiniami);

        adapter = new Adapter(this, titles,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        rv_grid.setLayoutManager(gridLayoutManager);
        rv_grid.setAdapter(adapter);

    }
}
