package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class GiaoDienChinh extends AppCompatActivity {
    Button btnlogout;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giao_dien_chinh);
        btnlogout = findViewById(R.id.btnLogout);
        mAuth = FirebaseAuth.getInstance();
        btnlogout.setOnClickListener(view->{
            mAuth.signOut();
            startActivity(new Intent(GiaoDienChinh.this,MainActivity.class));
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user == null){
            startActivity(new Intent(GiaoDienChinh.this,MainActivity.class));
        }

    }
}