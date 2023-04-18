package com.masterandroid.ehome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MessageActivity extends AppCompatActivity {

    private EditText txt_service;
    private EditText txt_location;
    private EditText txt_street;
    private EditText txt_mobile;
    private EditText txt_identity;
    private Spinner spinnerPayment_mode;
    private Button btn_send;
    int i = 0;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference clientDbRef;
    Clients clients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);


        txt_service = findViewById(R.id.service);
        txt_location = findViewById(R.id.location);
        txt_street = findViewById(R.id.street);
        txt_mobile = findViewById(R.id.mobile);
        txt_identity = findViewById(R.id.identity);
        spinnerPayment_mode = findViewById(R.id.spinnerPayment_mode);
        btn_send = findViewById(R.id.send);

        clientDbRef = FirebaseDatabase.getInstance().getReference().child("Clients ");

        Intent intent = getIntent();
        String str = intent.getStringExtra("Service");
        txt_service.setText(str);


        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                insertClienttData();

        }
        });
    }



    private void insertClienttData(){
        String service = txt_service.getText().toString();
        String location = txt_location.getText().toString();
        String street = txt_street.getText().toString();
        String mobile = txt_mobile.getText().toString();
        String identity = txt_identity.getText().toString();
        String payment_mode = spinnerPayment_mode.getSelectedItem().toString();

        if(service.isEmpty() || location.isEmpty() || street.isEmpty() || mobile.isEmpty() || identity.isEmpty() || payment_mode.isEmpty()){
            Toast.makeText(MessageActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
        } else {


            Clients clients = new Clients(service, location, street, mobile, identity, payment_mode);
            clientDbRef.push().setValue(clients);
            Toast.makeText(MessageActivity.this, "Your order has been successfully received", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MessageActivity.this, Apreciation.class));
            finish();
        }
    }


}