package com.masterandroid.ehome;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Declare the views
    private Button electrician;
    private Button plumber;
    private Button painter;
    private Button babysitter;
    private Button driver;
    private Button guard;
    private  Button software;
    private Button mason;
    private Button tutor;
    private Button carpenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialize the views
        electrician = findViewById(R.id.Hireelect);
        plumber = findViewById(R.id.Hireplumber);
        painter = findViewById(R.id.Hirepainter);
        babysitter = findViewById(R.id.Hirebaby);
        driver = findViewById(R.id.Hiredriver);
        guard = findViewById(R.id.Hireguard);
        software = findViewById(R.id.Hiresoft);
        carpenter = findViewById(R.id.Hirecarpenter);
        tutor = findViewById(R.id.Hiretutor);
        mason = findViewById(R.id.Hiremason);

        //Add an onClickListener when electrician is clicked

        electrician.setOnClickListener(new View.OnClickListener() {
            //Declare and initialize a String that will be passed to the message activity
            String str = "Service: Electrician";
            @Override
            public void onClick(View view) {
                //Declare and initialize an intent to navigate to message activity
                Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                //Attach the string to be passed to the intent
                intent.putExtra("Service", str);
                //Call the startActivity to navigate to message
                startActivity(intent);
            }
        });

        plumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "Service: Plumber";
                Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                intent.putExtra("Service", str);
                startActivity(intent);

            }
        });

        painter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "Service: Painter";
                Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                intent.putExtra("Service", str);
                startActivity(intent);
            }
        });

        babysitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "Service: Babysitter";
                Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                intent.putExtra("Service", str);
                startActivity(intent);
            }
        });

        driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "Service: Driver";
                Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                intent.putExtra("Service", str);
                startActivity(intent);
            }
        });

        guard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "Service: Guard";
                Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                intent.putExtra("Service", str);
                startActivity(intent);
            }
        });

        tutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "Service: Tutor";
                Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                intent.putExtra("Service", str);
                startActivity(intent);
            }
        });

        mason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "Service: Mason";
                Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                intent.putExtra("Service", str);
                startActivity(intent);
            }
        });

        software.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "Service: Software Installer";
                Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                intent.putExtra("Service", str);
                startActivity(intent);
            }
        });

        carpenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "Service: Carpenter";
                Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                intent.putExtra("Service", str);
                startActivity(intent);
            }
        });

    }
}