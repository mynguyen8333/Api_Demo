package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    Button btnSignup;
    EditText edEmail,edPassWord1;
    TextView tvsignin;
    //khai bao bien Firebase
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //dang kí
        btnSignup = findViewById(R.id.btnSignup);
        edEmail = findViewById(R.id.edEmail_Signup);
        edPassWord1 = findViewById(R.id.edPass_Signup1);
        tvsignin = findViewById(R.id.tvSignin);
        //ket noi
        mAuth = FirebaseAuth.getInstance();
        //dang kí
        btnSignup.setOnClickListener(view->{
            createUser();
        });
        tvsignin.setOnClickListener(view->{
            startActivity(new Intent(SignUp.this,MainActivity.class));
        });

    }
    private  void createUser(){
        String email = edEmail.getText().toString();
        String password = edPassWord1.getText().toString();

        if(email.equalsIgnoreCase(null)){
            Toast.makeText(SignUp.this,"Chua nhap email",Toast.LENGTH_SHORT).show();
        }else if(password.equalsIgnoreCase(null)){
            Toast.makeText(SignUp.this,"Chua nhap pass",Toast.LENGTH_SHORT).show();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(SignUp.this,"Dang ki thanh cong",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignUp.this,MainActivity.class));
                    }else{
                        Toast.makeText(SignUp.this,"Dang ki that bai",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}