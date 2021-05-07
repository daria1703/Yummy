package com.example.yummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yummy.Connect.Database;

import java.sql.SQLException;

public class RegistrationActivity extends AppCompatActivity {

    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //test klasy Database
                Database db = new Database();
                try {
                    db.getUsersData();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

    }

    public void goToSignIn(View view) {
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }


}