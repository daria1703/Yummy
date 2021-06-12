package com.example.yummy;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yummy.Connect.Database;
import com.example.yummy.Connect.RecipeData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.graphics.Color.RED;

public class RecipeActivity extends AppCompatActivity {

    ImageView image_of_dish;
    TextView title_of_dish, description, ingredients, time;
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
        description = findViewById(R.id.description);
        ingredients = findViewById(R.id.inredients);
        time = findViewById(R.id.time);
        heart_btn = findViewById(R.id.heart_btn);
        comments_btn = findViewById(R.id.comments_btn);


        heart_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                heart_btn.setImageResource(R.drawable.ic_heart);
            }
        });

        switch (chosenCategory.toLowerCase()) {
            case "pizza":
                image_of_dish.setImageResource(R.drawable.pizza_pasterska);
                break;
            case "cake":
                image_of_dish.setImageResource(R.drawable.ciasto_gora_lodowa);
                break;
            case "cupcake":
                image_of_dish.setImageResource(R.drawable.muffiny_czekoladowe_00);
                break;
            case "dinner":
                image_of_dish.setImageResource(R.drawable.makaron_z_pulpecikami_w_sosie_carbonara);
                break;
            case "drink":
                image_of_dish.setImageResource(R.drawable.bombardino);
                break;
        }


        try {
            List<RecipeData> recipes = Database.fetchRecipes();
            List<RecipeData> chosenRecipes = new ArrayList<>();

            //wybranie przepisów danej kategorii
            for (RecipeData recipe : recipes) {
                if (recipe.getCategory().toLowerCase().equals(chosenCategory.toLowerCase())) {
                    chosenRecipes.add(recipe);
                }
            }

            //wylosowanie jednego przepisu
            Random random = new Random();
            int chosenRecipeNumber = random.nextInt(chosenRecipes.size());
            RecipeData chosenRecipe = chosenRecipes.get(chosenRecipeNumber);

            //wyświetlenie wybranego przepisu
            title_of_dish.setText(chosenRecipe.getTitle());
            description.setText(chosenRecipe.getDescription());
            ingredients.setText(chosenRecipe.getIngredients());
            time.setText(chosenRecipe.getTime());


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void onClick(View view) {
    }
}