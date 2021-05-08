package com.example.yummy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class StartScreen extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StaticRvAdapter staticRvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        ArrayList<StaticRvModel> item = new ArrayList<>();
        item.add(new StaticRvModel(R.drawable.ic_pizza,"Pizza"));
        item.add(new StaticRvModel(R.drawable.ic_cake_rv,"Cake"));
        item.add(new StaticRvModel(R.drawable.ic_cup_cake,"Cupcake"));
        item.add(new StaticRvModel(R.drawable.ic_banquet,"Dinner"));
        item.add(new StaticRvModel(R.drawable.ic_banquet,"Drink"));

        recyclerView = findViewById(R.id.rv1);
        staticRvAdapter = new StaticRvAdapter(item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(staticRvAdapter);

    }
}