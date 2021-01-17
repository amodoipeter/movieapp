package com.moringaschool.movieapp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.moringaschool.movieapp.R;

/**
 * @author moringa
 */
public class MainActivity1 extends AppCompatActivity {
    EditText emailId, password;
    Button btnSignUp;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        btnSignUp = findViewById(R.id.button2);
        tvSignIn = findViewById(R.id.textView);
        btnSignUp.setOnClickListener(v -> {
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
                Toast.makeText(MainActivity1.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
            }
            else  if(!(email.isEmpty() && pwd.isEmpty())){
                mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(MainActivity1.this, task -> {
                    if(!task.isSuccessful()){
                        Toast.makeText(MainActivity1.this,"SignUp Unsuccessful, Please Try Again",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        startActivity(new Intent(MainActivity1.this,MainActivity.class));
                    }
                });
            }
            else{
                Toast.makeText(MainActivity1.this,"Error Occurred!",Toast.LENGTH_SHORT).show();

            }
        });

        tvSignIn.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity1.this, LoginActivity.class);
            startActivity(i);
        });
    }
}
