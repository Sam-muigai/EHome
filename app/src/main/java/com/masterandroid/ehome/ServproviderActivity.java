package com.masterandroid.ehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ServproviderActivity extends AppCompatActivity {

    //Declare the views
    private EditText txt_firstname;
    private EditText txt_lastname;
    private EditText txt_email;
    private EditText txt_sOffer;
    private EditText txt_certif;
    private EditText txt_mobile;
    private EditText txt_identity;
    private  EditText txt_location;
    private Button btnEnter;

    //Create an object from DatabaseReference class
    DatabaseReference serviceDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servprovider);

        //Initialize the views
        txt_firstname = findViewById(R.id.firstname);
        txt_lastname = findViewById(R.id.lastname);
        txt_email = findViewById(R.id.email);
        txt_sOffer = findViewById(R.id.sOffer);
        txt_certif = findViewById(R.id.certif);
        txt_mobile = findViewById(R.id.mobile);
        txt_identity = findViewById(R.id.identity);
        txt_location = findViewById(R.id.location);
        btnEnter = findViewById(R.id.btnEnter);

        //Initialize the object with an instance of firebase realtime database
        serviceDbRef = FirebaseDatabase.getInstance().getReference().child("ServiceProviders");

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertServiceProvidersData();
            }
        });

    }

    /*
    *This function is used to insert data to firebase realtime database
    * */
    private void insertServiceProvidersData() {
        String firstname = txt_firstname.getText().toString();
        String lastname = txt_lastname.getText().toString();
        String email = txt_email.getText().toString();
        String serviceoffering = txt_sOffer.getText().toString();
        String certnumber = txt_certif.getText().toString();
        String identity = txt_identity.getText().toString();
        String mobile = txt_mobile.getText().toString();
        String location = txt_location.getText().toString();

        //Input validation
        if(firstname.isEmpty() || lastname.isEmpty() || email.isEmpty() || serviceoffering.isEmpty() || certnumber.isEmpty() || identity.isEmpty() || mobile.isEmpty() || location.isEmpty()){
            Toast.makeText(ServproviderActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
        }else{
            Regservice regservice = new Regservice(firstname,lastname,email,serviceoffering,certnumber,identity,mobile, location);
            serviceDbRef.push().setValue(regservice);
            Toast.makeText(ServproviderActivity.this, "Thank you for registering with Home providers' app", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ServproviderActivity.this, Apreciation.class));
            finish();
        }
    }
}