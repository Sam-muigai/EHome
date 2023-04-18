package com.masterandroid.ehome;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    //Declare the views
    private Button serviceman;
    private Button servicebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //Initialize the views
        serviceman = findViewById(R.id.servicemanbtn);
        servicebtn = findViewById(R.id.servicebtn);

        //Navigate to view services when button is clicked
        servicebtn.setOnClickListener(view -> startActivity(new Intent(WelcomeActivity.this , MainActivity.class)));
        //Navigate to add services when button is clicked
        serviceman.setOnClickListener(view -> startActivity(new Intent(WelcomeActivity.this , ServproviderActivity.class)));
    }
}