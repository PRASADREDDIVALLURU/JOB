package com.example.job;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginScreen extends AppCompatActivity {
    EditText email1,password1;
    private FirebaseAuth Auth;
    ProgressDialog progressDialog;
    private static int splash = 700;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginscreen);
        email1=findViewById(R.id.email);
        password1=findViewById(R.id.pwd);
        Auth = FirebaseAuth.getInstance();
    }

    public void login(View view) {
        String email = email1.getText().toString().trim();
        String password = password1.getText().toString().trim();
        if(TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){
            Toast.makeText(this,"Fill the Email & Password", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this,"Fill the Email Address", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Fill the Password", Toast.LENGTH_SHORT).show();
            return;
        }
        if(password.length()<5){
            Toast.makeText(this,"Enter Strong Password", Toast.LENGTH_SHORT).show();
        }
        Auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(LoginScreen.this, Signout.class));
                    Toast.makeText(LoginScreen.this,"Login Successfull", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(LoginScreen.this,"Invalid User", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void forgot(View view) {
        progressDialog = new ProgressDialog(LoginScreen.this);
        progressDialog.show();
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
                startActivity(new Intent(LoginScreen.this,Forgot.class));
                return;
            }
        },splash);
    }
    public void onBackPressed(){
        AlertDialog.Builder alert = new AlertDialog.Builder(LoginScreen.this);
        alert.setMessage("Do You Want Close App").setCancelable(false).setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        alert.show();
    }
    public void signup(View view) {
        startActivity(new Intent(LoginScreen.this,RegisterScreen.class));
    }


}
