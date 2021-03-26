package com.example.codemetapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SinUpAcitvity extends AppCompatActivity {

    EditText edtname,edtnum,edtmail,edtpsw;
    Spinner sp;
    TextView havecreate;
    ProgressBar progressBar;
    Button signup;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sin_up_acitvity);

        havecreate = findViewById(R.id.havecreate);
        edtname = findViewById(R.id.edtname);
        edtnum = findViewById(R.id.edtnum);
        edtmail = findViewById(R.id.edtmail);
        edtpsw = findViewById(R.id.edtpsw);
        sp = findViewById(R.id.spinner);
        progressBar = findViewById(R.id.progressBar);
        signup = findViewById(R.id.signup);
        fAuth = FirebaseAuth.getInstance();

        if (fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            finish();

        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.usertype, R.layout.support_simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String mail = edtmail.getText().toString().trim();
                String psw = edtpsw.getText().toString().trim();

                if(TextUtils.isEmpty(mail)){
                    edtmail.setError("Email IS REquired");
                    return;
                }
                if (TextUtils.isEmpty(psw)){
                    edtpsw.setError("Password Is Required");
                    return;
                }
                if(psw.length() < 8){
                    edtpsw.setError("Password Must Be >= 8 Characters");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                fAuth.createUserWithEmailAndPassword(mail,psw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(SinUpAcitvity.this,"User Created",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        }else {
                            Toast.makeText(SinUpAcitvity.this, "Error !" +  task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        havecreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SinUpAcitvity.this , SignInActivity.class);
                startActivity(i);
            }
        });
    }
}