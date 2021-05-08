package com.example.yummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yummy.Connect.Database;
import com.example.yummy.Connect.UserData;

import java.util.List;

public class Dashboard extends AppCompatActivity {

    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        email = findViewById(R.id.EditEmail);
        password = findViewById(R.id.editPassword);
    }

    public void signIn(View view) {
        String email = this.email.getText().toString();
        String password = this.password.getText().toString();

        if (email.isEmpty()) {
            makeToast("Enter your email address!");
        }
        if (password.isEmpty()) {
            makeToast("Enter password!");
        }else if (isNetworkAvailable()) {

            UserData user = validateUser(email, password);

            if (user != null) {
                makeToast("Hi " + user.getNick() + ", it's nice to see you");
                Intent intent = new Intent(this, GalleryActivity.class);
                startActivity(intent);
            } else {
                makeToast("Invalid email or password!");
            }

        } else {
            makeToast("Check your Internet connection and try again...");
        }
    }

    public void goToRegistration(View view) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void makeToast(String text) {
        Context context = getApplicationContext();

        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.show();
    }

    private UserData validateUser(String email, String password) {
        Database db = new Database();
        try {
            List<UserData> users = db.getUsersData();
            for (UserData user: users) {
                if (user.getEmail().equals(email)) {
                    if (user.getPassword().equals(password)) {
                        return user;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}