package com.example.aptapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.aptapp.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private Button registerButton_LoginScreen;
    private FirebaseAuth mAuth;
    private Button loginButton_LoginScreen;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerButton_LoginScreen = findViewById(R.id.registerButton);
        loginButton_LoginScreen = findViewById(R.id.LoginButton);
        email = findViewById(R.id.UsernameField);
        password = findViewById(R.id.PasswordField);

        mAuth = FirebaseAuth.getInstance();


        registerButton_LoginScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegisterScreen();

            }
        });
        loginButton_LoginScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomeScreen();
            }


        });

        //openGoogleMaps();
    }
    public void openHomeScreen(){
        Intent intent = new Intent(this, test_activity.class);
        startActivity(intent);
    }

    public void openRegisterScreen(){

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);


    }
    @Override
    public void onStart()
    {
        super.onStart();
        //FirebaseUser currentUser = mAuth.getCurrentUser();
        //UpdateUI(currentUser);
    }




}
