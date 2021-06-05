package com.example.yummy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class Recipe extends AppCompatActivity {

    ImageView imgae_od_dish;
    TextView title_of_dish;
    Button heart_btn;
    Button comments_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        imgae_od_dish = findViewById(R.id.imgae_od_dish);
        title_of_dish = findViewById(R.id.title_of_dish);
        heart_btn = findViewById(R.id.heart_btn);
        comments_btn = findViewById(R.id.comments_btn);

    }


}
