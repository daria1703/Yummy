package com.example.yummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.yummy.Connect.Database;

import java.sql.SQLException;

public class RegistrationActivity extends AppCompatActivity {

    Button btnRegister;
    EditText fullName, nick, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btnRegister = findViewById(R.id.btnRegister);

        fullName = findViewById(R.id.EditFirstName);
        nick = findViewById(R.id.EditNick);
        email = findViewById(R.id.EditEmail2);
        password = findViewById(R.id.editPassword);

        //TODO dodać walidację danych
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Database();
                Database.addUser(fullName.getText().toString(), nick.getText().toString(),
                        email.getText().toString(), password.getText().toString());
            }
        });

    }

    public void goToSignIn(View view) {
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }


}