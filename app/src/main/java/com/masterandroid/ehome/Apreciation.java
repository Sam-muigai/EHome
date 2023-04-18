package com.masterandroid.ehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Apreciation extends AppCompatActivity {
    //Declare a button View
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apreciation);
        //Initialize the view
        logout = findViewById(R.id.logout);
        //Navigate the user to start activity if he/she is not registered.
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Apreciation.this, "Logged out", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Apreciation.this , StartActivity.class));
            }
        });
    }
}