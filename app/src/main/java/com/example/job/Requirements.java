package com.example.job;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Requirements extends AppCompatActivity {
    EditText wrkhrs,scpwrk,salreq,userreq;
    EditText mail,pwd;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requirements);
        wrkhrs=findViewById(R.id.time);
        scpwrk=findViewById(R.id.work);
        salreq=findViewById(R.id.salary);
        userreq=findViewById(R.id.other);

        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(this, Requirements.class));
        }

    }

    public void Save(View view) {
        String email = mail.getText().toString().trim();
        String pwd1 = pwd.getText().toString().trim();
        String time = wrkhrs.getText().toString().trim();
        String work =scpwrk.getText().toString().trim();
        String salary = salreq.getText().toString().trim();
        String other= userreq.getText().toString().trim();

        if (email.isEmpty() || pwd1.isEmpty() ||time.isEmpty()||work.isEmpty()||salary.isEmpty()||other.isEmpty()) {
            Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show();
        }
        auth.signInWithEmailAndPassword(email, pwd1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Requirements.this, "Date saved", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Requirements.this, RegAct2.class));
                    finish();
                } else {
                    Toast.makeText(Requirements.this, "DATA NOT SAVED", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void Goback(View view) {
        Intent i = new Intent(this,RegAct2.class);
        startActivity(i);
    }
}

