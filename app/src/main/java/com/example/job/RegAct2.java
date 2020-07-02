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
import com.google.firebase.database.DatabaseReference;

public class RegAct2 extends AppCompatActivity {


    EditText mail,pwd;
    FirebaseAuth auth;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser()!=null)
        {
            startActivity(new Intent(this,RegAct2.class));
        }

    }

    public void Personaldetails(View view)
    {



        startActivity(new Intent(this,Personaldetails.class));

    }

    public void Educationaldetails(View view) {


        startActivity(new Intent(this,Educationdetails.class));

    }

    public void Requirements(View view) {


        startActivity(new Intent(this,Requirements.class));

    }

    public void Projectlinks(View view) {


        startActivity(new Intent(this,Project_link.class));

    }



    public void Register(View view) {
        String email = mail.getText().toString().trim();
        String password = pwd.getText().toString().trim();
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show();
            mail.setError("field can't be empty");


        }
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(RegAct2.this, Personaldetails.class));
                    finish();
                    Toast.makeText(RegAct2.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegAct2.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
//if once clicked register it should navigate to the home page//


