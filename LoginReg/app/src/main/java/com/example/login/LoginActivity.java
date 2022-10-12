package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText regisemail, regispassword;
    Button login;
    FirebaseAuth fAuth;
//    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        regisemail      = findViewById(R.id.email);
        regispassword   = findViewById(R.id.password);
        login = findViewById(R.id.login);
        fAuth = FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email       = regisemail.getText().toString();
                String password    = regispassword.getText().toString();
                if (TextUtils.isEmpty(email)){
                    regisemail.setError("Email Dibutuhkan");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    regispassword.setError("Password Dibutuhkan");
                    return;
                }
                if (password.length()< 6){
                    regispassword.setError("Password harus lebih dari 6 karakter");
                    return;

                }
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Berhasil Masuk", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        }else {
                            Toast.makeText(LoginActivity.this, "Akun Gagal Dibuat"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }

                });

            }
        });

    }
    public void pindahHomeActivity(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    public void pindahDaftarActivity(View view){
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }
//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
////        updateUI(currentUser);
//    }
}