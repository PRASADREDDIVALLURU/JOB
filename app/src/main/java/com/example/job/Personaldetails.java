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

public class Personaldetails extends AppCompatActivity {
    EditText adhno,passno,padd,fname,mars;
    EditText mail,pwd;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaldetails);
        auth = FirebaseAuth.getInstance();
        adhno=findViewById(R.id.Aadhar);
        passno=findViewById(R.id.passport);
        padd=findViewById(R.id.p_address);
        fname=findViewById(R.id.daddy);
        mars=findViewById(R.id.maritalstatus);
        if(auth.getCurrentUser()!=null)
        {
            startActivity(new Intent(this,Personaldetails.class));
        }

    }


    public void Save(View view)
    {
        String email= mail.getText().toString().trim();
        String pwd1 = pwd.getText().toString().trim();
        String Aadhar = adhno.getText().toString().trim();
        String passport = passno.getText().toString().trim();
        String p_address= padd.getText().toString().trim();
        String daddy = fname.getText().toString().trim();
        String maritalstatus = mars.getText().toString().trim();

        if(email.isEmpty()||pwd1.isEmpty()||Aadhar.isEmpty()||passport.isEmpty()||p_address.isEmpty()||daddy.isEmpty()||maritalstatus.isEmpty() )
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
                    Toast.makeText(Personaldetails.this, "Date saved", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Personaldetails.this,RegAct2.class));
                }
                else
                {
                    Toast.makeText(Personaldetails.this, "DATA NOT SAVED", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void Update(View view) {

        Intent i = new Intent(this, RegAct2.class);
        startActivity(i);
    }

}