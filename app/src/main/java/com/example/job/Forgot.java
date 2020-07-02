package com.example.job;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forgot extends AppCompatActivity {
    EditText email4;
    FirebaseAuth Auth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        email4=findViewById(R.id.email);
        Auth=FirebaseAuth.getInstance();

    }
    public void forgot(View view){
        String email=email4.getText().toString().trim();
        if (TextUtils.isEmpty(email)){
            Toast.makeText(this,"Enter a Email", Toast.LENGTH_SHORT).show();
            return;
        }
        Auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(Forgot.this ,"Reset  send  link", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Forgot.this,"Enter Correct Email", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}