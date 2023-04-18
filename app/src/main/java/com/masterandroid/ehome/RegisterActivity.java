package com.masterandroid.ehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    //Declare the views
    private EditText regusername;
    private EditText regemail;
    private EditText regpassword;
    private EditText regconfirmpass;
    private Button btnsignup;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //Initialize the view
        regusername = findViewById(R.id.regusername);
        regemail = findViewById(R.id.regemail);
        regpassword = findViewById(R.id.regpassword);
        regconfirmpass = findViewById(R.id.regconfirmpass);
        btnsignup = findViewById(R.id.btnsignup);

        auth = FirebaseAuth.getInstance();

        /*
        *Set an onClickListener to respond when the user clicks sign up
        * */
        btnsignup.setOnClickListener(view -> {
            String txt_username = regusername.getText().toString();
            String txt_email = regemail.getText().toString();
            String txt_password = regpassword.getText().toString();
            String txt_confirmpass = regconfirmpass.getText().toString();

            //This code is used for input validation
            if (TextUtils.isEmpty(txt_username) || TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)
            || TextUtils.isEmpty(txt_confirmpass)){
                Toast.makeText(RegisterActivity.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
            } else if (txt_password.length() < 6){
                Toast.makeText(RegisterActivity.this, "Password too short", Toast.LENGTH_SHORT).show();
            } else {
                registerUser(txt_email , txt_password);
            }
        });
    }

    /*
    * Function to register user via firebase
    * After registration is complete the user is directed to the login page
    * */
    private void registerUser(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterActivity.this,task->{
            if (task.isSuccessful()){
                Toast.makeText(RegisterActivity.this, "Registering user successful", Toast.LENGTH_SHORT).show();
                //Direct the user to the login page
                startActivity(new Intent(RegisterActivity.this , StartActivity.class));
                Toast.makeText(RegisterActivity.this, "Login to use the App", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(RegisterActivity.this,"Registration failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}