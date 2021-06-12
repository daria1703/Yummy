package com.example.yummy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yummy.Connect.Database;
import com.example.yummy.Connect.RecipeData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecipeActivity extends AppCompatActivity {

    ImageView image_of_dish;
    TextView title_of_dish;
    FloatingActionButton heart_btn;
    FloatingActionButton comments_btn;

    String chosenCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        chosenCategory = this.getIntent().getStringExtra("chosenCategory");

        image_of_dish = findViewById(R.id.image_of_dish);
        title_of_dish = findViewById(R.id.title_of_dish);
        heart_btn = findViewById(R.id.heart_btn);
        comments_btn = findViewById(R.id.comments_btn);


        try {
            List<RecipeData> recipes = Database.fetchRecipes();
            List<RecipeData> chosenRecipes = new ArrayList<>();

            //wybranie przepisów danej kategorii
            for (RecipeData recipe: recipes) {
                if(recipe.getCategory().toLowerCase().equals(chosenCategory.toLowerCase())) {
                    chosenRecipes.add(recipe);
                }
            }

            //wylosowanie jednego przepisu
            Random random = new Random();
            int max = chosenRecipes.size();
            int chosenRecipeNumber = random.nextInt(max + 1);
            RecipeData chosenRecipe = chosenRecipes.get(chosenRecipeNumber);

            //wyświetlenie wybranego przepisu

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}