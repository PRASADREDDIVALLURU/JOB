package com.example.job;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Educationdetails extends AppCompatActivity {


    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educationdetails);
        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser()!=null)
        {
            startActivity(new Intent(this,Educationdetails.class));
        }

    }



    public void EngineeringDetails(View view) {

        startActivity(new Intent(this,Eng_details.class));
    }

    public void Interdetails(View view) {
        startActivity(new Intent(this,Inter_details.class));
    }

    public void SSCdetails(View view) {
        startActivity(new Intent(this,ssc_details.class));
    }





    public void Goback(View view) {
        Intent i = new Intent(this,RegAct2 .class);
        startActivity(i);
    }
}
