package com.example.yummy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.yummy.service.LoggedUser;

public class UserActivity extends AppCompatActivity {

    TextView nick, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        nick = findViewById(R.id.user_nick);
        email = findViewById(R.id.user_mail);

        nick.setText(LoggedUser.getNick());
        email.setText(LoggedUser.getEmail());
    }
}