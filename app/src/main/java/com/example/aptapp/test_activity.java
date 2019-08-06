package com.example.aptapp;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aptapp.R;
import com.example.aptapp.ui.login.LoginViewModel;
import com.example.aptapp.ui.login.LoginViewModelFactory;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class test_activity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);

        final ImageButton profile =findViewById(R.id.imageButton2);
        final ImageButton makePost = findViewById(R.id.imageButton);
        final Button mapButton = findViewById(R.id.mapButton);

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGoogleMaps();
            }
        });

        makePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPost();
            }
        });
    }

    public void openGoogleMaps(){
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=");
        Intent intent2 = new Intent (Intent.ACTION_VIEW, gmmIntentUri);
        intent2.setPackage("com.google.android.apps.maps");
        startActivity(intent2);
    }
    public void openPost(){
        Intent intent3 = new Intent(this,  PostActivity.class);

        startActivity(intent3);
    }
}
