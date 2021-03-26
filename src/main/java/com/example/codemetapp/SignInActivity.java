package com.example.codemetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity {

    EditText edtmail,edtpsw;
    Spinner sp;
    TextView wantcreate,forgetpsw;
    ProgressBar progressBar;
    Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        wantcreate = findViewById(R.id.wantcreate);
        forgetpsw = findViewById(R.id.forgetpsw);
        edtmail = findViewById(R.id.edtmail);
        edtpsw = findViewById(R.id.edtpsw);
        sp = findViewById(R.id.spinner);
        progressBar = findViewById(R.id.progressBar);
        signin = findViewById(R.id.signin);

        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.usertype, R.layout.support_simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

        wantcreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignInActivity.this , SinUpAcitvity.class);
                startActivity(i);
            }
        });
    }
}