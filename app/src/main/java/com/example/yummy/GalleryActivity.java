package com.example.yummy;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GalleryActivity extends AppCompatActivity {
    ImageView image1, image2, image3, image4;
    TextView category;

    String chosenCategory;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        chosenCategory = this.getIntent().getStringExtra("chosenCategory");

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);

        category = findViewById(R.id.category);
        category.setText(chosenCategory);

        switch (chosenCategory) {
            case "Pizza":
                image1.setImageDrawable(getDrawable(R.drawable.pizza_hiszpanska_05_0));
                image2.setImageDrawable(getDrawable(R.drawable.pizza_pasterska));
                image3.setImageDrawable(getDrawable(R.drawable.pizza_wegierska2));
                image4.setImageDrawable(getDrawable(R.drawable.pizza_z_gorgonzola_pomidorami));
                break;
            case "Cake":
                image1.setImageDrawable(getDrawable(R.drawable.szarlotka_z_budyniem_1));
                image2.setImageDrawable(getDrawable(R.drawable.sernik_swiateczny_z_brzoskwiniami));
                image3.setImageDrawable(getDrawable(R.drawable.ciasto_lion_01_0));
                image4.setImageDrawable(getDrawable(R.drawable.czekoladowe_chmurki_1));
                break;
            case "Cupcake":
                image1.setImageDrawable(getDrawable(R.drawable.muffiny_z_truskawkami));
                image2.setImageDrawable(getDrawable(R.drawable.muffiny_czekoladowe_z_nutella_sliwkami));
                image3.setImageDrawable(getDrawable(R.drawable.muffiny_bananowe_01_0));
                image4.setImageDrawable(getDrawable(R.drawable.muffinki_czekoladowe_bezglutenowe));
                break;
            case "Dinner":
                image1.setImageDrawable(getDrawable(R.drawable.zupa_z_cukinia_ziemniakami_feta));
                image2.setImageDrawable(getDrawable(R.drawable.makaron_z_truskawkami));
                image3.setImageDrawable(getDrawable(R.drawable.makaron_z_pulpecikami_w_sosie_carbonara));
                image4.setImageDrawable(getDrawable(R.drawable.dorsz_w_sosie_curry));
                break;
            case "Drink":
                image1.setImageDrawable(getDrawable(R.drawable.smoothie_z_batatow));
                image2.setImageDrawable(getDrawable(R.drawable.malinowa_agua_fresca));
                image3.setImageDrawable(getDrawable(R.drawable.czekolada_na_goraco_na_czerwonym_winie));
                image4.setImageDrawable(getDrawable(R.drawable.bombardino));
                break;

        }

    }

    public void onClick(View view) {

    }
}