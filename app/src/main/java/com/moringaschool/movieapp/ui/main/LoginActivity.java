package com.moringaschool.movieapp.ui.main;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.moringaschool.movieapp.R;

/**
 * @author moringa
 */
public class LoginActivity extends AppCompatActivity {
    EditText emailId, password;
    Button btnSignIn;
    TextView tvSignUp;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        btnSignIn = findViewById(R.id.button2);
        tvSignUp = findViewById(R.id.textView);

        mAuthStateListener = firebaseAuth -> {
            FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
            if( mFirebaseUser != null ){
                Toast.makeText(com.moringaschool.movieapp.ui.main.LoginActivity.this,"You are logged in",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(com.moringaschool.movieapp.ui.main.LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
            else{
                Toast.makeText(com.moringaschool.movieapp.ui.main.LoginActivity.this,"Please Login",Toast.LENGTH_SHORT).show();
            }
        };

        btnSignIn.setOnClickListener(v -> {
            String email = emailId.getText().toString();
            String pwd = password.getText().toString();
            if(email.isEmpty()){
                emailId.setError("Please enter email id");
                emailId.requestFocus();
            }
            else  if(pwd.isEmpty()){
                password.setError("Please enter your password");
                password.requestFocus();
            }
            else  if(email.isEmpty() && pwd.isEmpty()){
                Toast.makeText(com.moringaschool.movieapp.ui.main.LoginActivity.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
            }
            else  if(!(email.isEmpty() && pwd.isEmpty())){
                mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(com.moringaschool.movieapp.ui.main.LoginActivity.this, task -> {
                    if(!task.isSuccessful()){
                        Toast.makeText(com.moringaschool.movieapp.ui.main.LoginActivity.this,"Login Error, Please Login Again",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Intent intToHome = new Intent(com.moringaschool.movieapp.ui.main.LoginActivity.this, MainActivity.class);
                        startActivity(intToHome);
                    }
                });
            }
            else{
                Toast.makeText(com.moringaschool.movieapp.ui.main.LoginActivity.this,"Error Occurred!",Toast.LENGTH_SHORT).show();

            }

        });

        tvSignUp.setOnClickListener(v -> {
            Intent intSignUp = new Intent(com.moringaschool.movieapp.ui.main.LoginActivity.this, MainActivity1.class);
            startActivity(intSignUp);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}
