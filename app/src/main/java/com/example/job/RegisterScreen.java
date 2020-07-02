package com.example.job;

import android.content.Intent;
import android.os.Bundle;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterScreen extends AppCompatActivity {
        EditText un, mail, phno, pwd, cpwd, hd;
        FirebaseAuth Auth;
        DatabaseReference reference;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_register_screen);
                un = findViewById(R.id.uname);
                mail = findViewById(R.id.email);
                phno = findViewById(R.id.num);
                pwd = findViewById(R.id.pwd);
                cpwd = findViewById(R.id.cpwd);
                hd = findViewById(R.id.highdeg);
                Auth = FirebaseAuth.getInstance();
                reference =FirebaseDatabase.getInstance().getReference("users");
                if (Auth.getCurrentUser()!=null)
                {
                        startActivity(new Intent(this,RegisterScreen.class));
                }


        }

        public void Continue(View view) {
                final String n = un.getText().toString();
                final String email =mail.getText().toString();
                final String p2 = phno.getText().toString();
                String password = pwd.getText().toString();
                String cp = cpwd.getText().toString();
                if (TextUtils.isEmpty(n)|| TextUtils.isEmpty(email)|| TextUtils.isEmpty(p2)|| TextUtils.isEmpty(password)|| TextUtils.isEmpty(cp)){
                        Toast.makeText(this,"please fill the details", Toast.LENGTH_SHORT).show();
                        return;
                }
                if (password.length()<6){
                        Toast.makeText(this,"password is too short", Toast.LENGTH_SHORT).show();
                        return;

                }
                if (password.equals(cp)){
                        Auth.createUserWithEmailAndPassword(email,password)

                                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {


                                                if (task.isSuccessful()){
                                                        Toast.makeText(RegisterScreen.this, "registration completed", Toast.LENGTH_SHORT).show();
                                                        Pojo pojo = new Pojo( n,p2,email);
                                                        reference.child(FirebaseAuth.getInstance().getUid()).setValue(pojo);
                                                }
                                        }

                        });
                }
                Intent i = new Intent(this,RegAct2.class);
                startActivity(i);

        }
}
