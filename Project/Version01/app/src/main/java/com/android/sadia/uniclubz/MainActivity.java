package com.android.sadia.uniclubz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView signup;
    private EditText emailEditText;
    private EditText passwordEditText;

    private Button loginButton;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        emailEditText = findViewById(R.id.input_email);
        passwordEditText = findViewById(R.id.input_password);

        signup = findViewById(R.id.sign_up);
        signup.setOnClickListener(this);

        loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(this);

    }

        @Override
        public void onClick(View v){
            switch (v.getId()){
                case R.id.sign_up:
                    startActivity(new Intent(this,SignupActivity.class));
                    break;

                case R.id.login_button:
                    loginUser();
                    break;

            }

        }

    private void loginUser() {
        String email = emailEditText.getText().toString().trim();
        String pass = passwordEditText.getText().toString().trim();

        if (email.isEmpty()) {
            emailEditText.setError("Email Address Required!");
            emailEditText.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Please Provide Valid Email");
            emailEditText.requestFocus();
            return;
        }

        if (pass.isEmpty()) {
            passwordEditText.setError("Password Required!");
            passwordEditText.requestFocus();
            return;
        }

        if (pass.length() < 6) {
            passwordEditText.setError("Password Cannot be Less than 6 Characters");
            passwordEditText.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                        } else {
                            Toast toast = Toast.makeText(MainActivity.this,
                                    "Failed to Login", Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }
                });
    }
}