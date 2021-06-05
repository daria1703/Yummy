package com.example.yummy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RecipeActivity extends AppCompatActivity {

    ImageView image_of_dish;
    TextView title_of_dish;
    FloatingActionButton heart_btn;
    FloatingActionButton comments_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        image_of_dish = findViewById(R.id.image_of_dish);
        title_of_dish = findViewById(R.id.title_of_dish);
        heart_btn = findViewById(R.id.heart_btn);
        comments_btn = findViewById(R.id.comments_btn);


    }
}