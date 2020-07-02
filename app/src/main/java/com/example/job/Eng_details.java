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

public class Eng_details extends AppCompatActivity {
    EditText clgname, psdout, marks, aff2;
    EditText mail, pwd;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eng_details);
        clgname = findViewById(R.id.clgname1);
        psdout = findViewById(R.id.year);
        marks = findViewById(R.id.num);
        aff2 = findViewById(R.id.aff);
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(this, Eng_details.class));
        }

    }


    public void Save(View view) {
        {
            String email = mail.getText().toString().trim();
            String pwd1 = pwd.getText().toString().trim();
            String clgname1 = clgname.getText().toString().trim();
            String year = psdout.getText().toString().trim();
            String num = marks.getText().toString().trim();
            String aff = aff2.getText().toString().trim();

            if (email.isEmpty() || pwd1.isEmpty() || clgname1.isEmpty() || year.isEmpty() || num.isEmpty() || aff.isEmpty()) {
                Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show();
            }
            auth.signInWithEmailAndPassword(email, pwd1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(Eng_details.this, "Date saved", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Eng_details.this, Educationdetails.class));
                        finish();
                    } else {
                        Toast.makeText(Eng_details.this, "DATA NOT SAVED", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }

    public void Back(View view) {
        Intent i = new Intent(this,Educationdetails .class);
        startActivity(i);


}
}




