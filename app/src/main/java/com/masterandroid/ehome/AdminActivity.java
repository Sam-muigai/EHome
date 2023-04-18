package com.masterandroid.ehome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {

    //Declare the views
    TextView text;
    Button btnserv;
    private ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        //Initialize the views
        text = (TextView) findViewById(R.id.textview);
        btnserv = findViewById(R.id.btnserv);
        //Button to navigate to service providers
        btnserv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminActivity.this, ServicemenActivity2.class));
            }
        });
        listView = findViewById(R.id.listView);

        final ArrayList<String> list = new ArrayList<>();
        final ArrayAdapter adapter = new ArrayAdapter<String>(this , R.layout.activity_admin,R.id.textview ,list);
        listView.setAdapter(adapter);

        //Create an instance of firebase realtime database
       DatabaseReference clientDbRef = FirebaseDatabase.getInstance().getReference().child("Clients ");
        clientDbRef.addValueEventListener(new ValueEventListener() {
            //Track changes of the database
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Clients info = snapshot.getValue(Clients.class);
                    String txt = info.getService() + "; \nlocation:" + info.getLocation() + "; \nstreet:" + info.getStreet() + "; \nPhone" + info.getMobile() + "; \nidentity:" + info.getIdentity() + "; \npaymode:" + info.getPayment_mode();
                    list.add(txt);
                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}