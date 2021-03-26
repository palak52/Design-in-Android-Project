package com.example.codemetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignActivity extends AppCompatActivity {

    Button btnlgn,btnreg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        getSupportActionBar().hide();

        btnlgn = findViewById(R.id.btnlogin);
        btnreg = findViewById(R.id.btnreg);

        btnlgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignActivity.this, SignInActivity.class);
                startActivity(i);
            }
        });
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignActivity.this, SinUpAcitvity.class);
                startActivity(i);
            }
        });
    }
}