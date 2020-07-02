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

public class Project_link extends AppCompatActivity {
    EditText np,np1,np2,np3,np4,np5;
    EditText mail,pwd;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_link);
        np=findViewById(R.id.projects);
        np1=findViewById(R.id.project1);
        np2=findViewById(R.id.project2);
        np3=findViewById(R.id.project3);
        np4=findViewById(R.id.project4);
        np5=findViewById(R.id.project5);
        if(auth.getCurrentUser()!=null)
        {
            startActivity(new Intent(this,Project_link.class));
        }

    }
    public void Upload(View view) {

        String email= mail.getText().toString().trim();
        String pwd1 = pwd.getText().toString().trim();
        String projects= np.getText().toString().trim();
        String project1= np1.getText().toString().trim();
        String project2= np2.getText().toString().trim();
        String project3= np3.getText().toString().trim();
        String project4= np4.getText().toString().trim();
        String project5= np5.getText().toString().trim();


        if(email.isEmpty()||pwd1.isEmpty()||projects.isEmpty() ||project1.isEmpty()||project2.isEmpty()||project3.isEmpty()||project4.isEmpty()||project5.isEmpty())
        {
            Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show();
        }
        auth.signInWithEmailAndPassword(email,pwd1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if(task.isSuccessful())
                {
                    Toast.makeText(Project_link.this, "Date saved", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Project_link.this,RegAct2.class));
                    finish();
                }
                else
                {
                    Toast.makeText(Project_link.this, "DATA NOT SAVED", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void Goback(View view) {
        Intent i = new Intent(this,RegAct2.class);
        startActivity(i);
    }
}
