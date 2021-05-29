package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button btnSignin;
    TextView tvSignup;
    EditText edEmail,edPassWord;
    //tao mot doi tuong Firebase Auth
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignin = findViewById(R.id.btnSignin);
        tvSignup = findViewById(R.id.tvSignup);
        edEmail = findViewById(R.id.edEmail_Signin);
        edPassWord = findViewById(R.id.edPass_Signin);
        //lKet noi
        mAuth = FirebaseAuth.getInstance();
        btnSignin.setOnClickListener(view->{
            loginUser();
        });
        tvSignup.setOnClickListener(view ->{
            startActivity(new Intent(MainActivity.this,SignUp.class));
        });
    }
    private void loginUser(){
        String email = edEmail.getText().toString();
        String passWord = edPassWord.getText().toString();
        if(email.equalsIgnoreCase(null)){
            Toast.makeText(MainActivity.this,"Chua nhap email",Toast.LENGTH_SHORT).show();
        }else if(passWord.equalsIgnoreCase(null)){
            Toast.makeText(MainActivity.this,"Chua nhap mat khau",Toast.LENGTH_SHORT).show();
        }else{
            mAuth.signInWithEmailAndPassword(email,passWord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                  if(task.isSuccessful()){
                      Toast.makeText(MainActivity.this,"Dang nhap thanh cong",Toast.LENGTH_SHORT).show();
                      startActivity(new Intent(MainActivity.this,GiaoDienChinh.class));

                  }else{
                      Toast.makeText(MainActivity.this,"Sai ten tai khoan hoac mat khau",Toast.LENGTH_SHORT).show();
                  }
                }
            });
//            mAuth.signInWithEmailAndPassword(email,passWord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//
//                }
//            });
        }
    }
}