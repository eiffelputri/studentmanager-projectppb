package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {
    EditText regisusername, regispassword, regsnim, regiskelas, regisemail;
    Button signup;
//    ProgressBar progressBar;
    FirebaseAuth fAuth;
    FirebaseDatabase database;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        regisusername = findViewById(R.id.Username);
        regisemail = findViewById(R.id.email);
        regispassword = findViewById(R.id.password);
        regsnim = findViewById(R.id.NIM);
        regiskelas = findViewById(R.id.kelas);
        signup = findViewById(R.id.signup);

        fAuth = FirebaseAuth.getInstance();
//        if (fAuth.getCurrentUser() !=null){
//            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
//            finish();
//        }
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ref = database.getReference("users");
                database    = FirebaseDatabase.getInstance();
                ref         = database.getReference("users");
                String username    = regisusername.getText().toString();
                String email       = regisemail.getText().toString().trim();
                String password    = regispassword.getText().toString().trim();
                String NIM         = regsnim.getText().toString();
                String kelas       = regiskelas.getText().toString();
                UserHelper helperClass = new UserHelper(NIM , username, kelas);
                ref.child(NIM).setValue(helperClass);

                if (TextUtils.isEmpty(email)){
                    regisemail.setError("Email Dibutuhkan");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    regispassword.setError("Password Dibutuhkan");
                    return;
                }
                if (TextUtils.isEmpty(username)) {
                    regisusername.setError("Username Dibutuhkan");
                    return;
                }
                if (TextUtils.isEmpty(NIM)){
                    regsnim.setError("NIM Dibutuhkan");
                    return;
                }
                if (TextUtils.isEmpty(kelas)){
                    regiskelas.setError("Kelas Dibutuhkan");
                    return;
                }
                if (password.length()< 6){
                    regispassword.setError("Password harus lebih dari 6 karakter");
                    return;
                }
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SignupActivity.this, "Akun Terbuat", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                        }else {
                            Toast.makeText(SignupActivity.this, "Akun Gagal Dibuat"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

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
}