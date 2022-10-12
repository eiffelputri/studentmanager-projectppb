package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Button homelogin, homesignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homelogin   = findViewById(R.id.homelogin);
        homesignup  = findViewById(R.id.homesignup);
        homelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlogin();
            }
        });
        homesignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensignup();
            }
        });
    }
    public void openlogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void opensignup(){
        Intent intent = new Intent(HomeActivity.this, SignupActivity.class);
        startActivity(intent);
    }
}