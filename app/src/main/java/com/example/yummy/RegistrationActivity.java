package com.example.yummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yummy.Connect.Database;

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

        btnRegister.setOnClickListener(v -> {
            if (isNetworkAvailable()) {
                makeToast("Signing in...");
                Database.connect();
                boolean isSuccess = Database.addUser(fullName.getText().toString(), nick.getText().toString(),
                        email.getText().toString(), password.getText().toString());
                makeToast("Signing Up Successful!");
                if (isSuccess) {
                    makeToast("Signing Up Successful!");
                } else {
                    makeToast("Something went wrong, try again later...");
                }

            } else {
                makeToast("Check your Internet connection and try again...");
            }
            goToSignIn();
        });

    }

    private void makeToast(String text) {
        Context context = getApplicationContext();

        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void goToSignIn(View view) {
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }

    public void goToSignIn() {
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


}