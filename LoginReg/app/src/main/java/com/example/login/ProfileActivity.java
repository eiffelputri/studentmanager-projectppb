package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {
Button keluarbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        keluarbutton = findViewById(R.id.keluarbutton);
        keluarbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensignout();
            }
        });
    }
    public void logout(View view) {
//        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
        finish();
    }
    public void opensignout(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    public void pindahHomeActivity(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}