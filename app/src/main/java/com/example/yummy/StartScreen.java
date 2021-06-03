package com.example.yummy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.yummy.DynamicRecycleView.LoadMore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StartScreen extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StaticRvAdapter staticRvAdapter;

    List<DynamicRVModel> items = new ArrayList();
    DynamicRVAdapter dynamicRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        final ArrayList<StaticRvModel> item = new ArrayList<>();
        item.add(new StaticRvModel(R.drawable.ic_pizza,"Pizza"));
        item.add(new StaticRvModel(R.drawable.ic_cake_rv,"Cake"));
        item.add(new StaticRvModel(R.drawable.ic_cup_cake,"Cupcake"));
        item.add(new StaticRvModel(R.drawable.ic_banquet,"Dinner"));
        item.add(new StaticRvModel(R.drawable.ic_quentao,"Drink"));

        recyclerView = findViewById(R.id.rv1);
        staticRvAdapter = new StaticRvAdapter(item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(staticRvAdapter);


        items.add(new DynamicRVModel("Pizza"));
        items.add(new DynamicRVModel("Pizza"));
        items.add(new DynamicRVModel("Pizza"));
        items.add(new DynamicRVModel("Pizza"));
        items.add(new DynamicRVModel("Pizza"));
        items.add(new DynamicRVModel("Pizza"));
        items.add(new DynamicRVModel("Pizza"));


        RecyclerView drv = findViewById(R.id.rv2);
        drv.setLayoutManager(new LinearLayoutManager(this));
        dynamicRVAdapter = new DynamicRVAdapter(drv,this,items);
        drv.setAdapter(dynamicRVAdapter);

        dynamicRVAdapter.setLoadMore(new LoadMore() {
            @Override
            public void onLoadMore() {
                if (items.size()<=10){
                    item.add(null);
                    dynamicRVAdapter.notifyItemInserted(items.size()-1);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            items.remove(items.size()-1);
                            dynamicRVAdapter.notifyItemInserted(items.size());

                            int index = items.size();
                            int end = index + 10;
                            for (int i = index; i < end; i++){
                                String name = UUID.randomUUID().toString();
                                DynamicRVModel item = new DynamicRVModel(name);
                                items.add(item);
                            }
                            dynamicRVAdapter.notifyDataSetChanged();
                            dynamicRVAdapter.setLoaded();

                        }
                    }, 4000);
                }
                else
                    Toast.makeText(StartScreen.this,"Data Completed", Toast.LENGTH_SHORT).show();
            }
        });

    }


}