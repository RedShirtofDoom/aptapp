package com.example.aptapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aptapp.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private Button registerButton_LoginScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerButton_LoginScreen = findViewById(R.id.registerButton);


        registerButton_LoginScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegisterScreen();

            }
        });

        openGoogleMaps();
    }

    public void openRegisterScreen(){

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);


    }



    public void openGoogleMaps(){
        Intent intent2 = new Intent (this,Map_apartment.class);
        startActivity(intent2);
    }
}
