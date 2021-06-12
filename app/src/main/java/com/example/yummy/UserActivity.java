package com.example.yummy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridView;

import com.example.yummy.databinding.ActivityMainBinding;

import java.util.List;

public class UserActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        String[] dishName = {"Babeczki", "Pizza", "Zupa", "Danie", "Ciasto"};
        int[] image = {R.drawable.muffiny_czekoladowe_00, R.drawable.pizza_pasterska, R.drawable.zupa_z_cukinia_ziemniakami_feta, R.drawable.dorsz_w_sosie_curry, R.drawable.ciasto_gora_lodowa};
        String[] descriptions = {"opis babczki bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "opis pizzy ppppppppppppppppppppp", "opis zupy zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz", "opis dania ddddddddddddddddddddddddddddddddddddddd", "opis ciasta ccccccccccccccccccccccccccccccccccccccccccccc"};

        GridAdapter gridAdapter = new GridAdapter(UserActivity.this,dishName,image,descriptions);
        binding.gridView.setAdapter(gridAdapter);


    }

}