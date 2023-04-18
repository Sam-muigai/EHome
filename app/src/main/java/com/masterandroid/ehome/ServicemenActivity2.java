package com.masterandroid.ehome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ServicemenActivity2 extends AppCompatActivity {
    //Declare a listView
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicemen2);

        //Initialize the view
        listView = findViewById(R.id.listView);

        final ArrayList<String> list = new ArrayList<>();
        final ArrayAdapter adapter = new ArrayAdapter<String>(this , R.layout.activity_servicemen2,R.id.txtviewreg ,list);
        //Populate the listView
        listView.setAdapter(adapter);

        //Create an instance of realtime database
        DatabaseReference serviceDbRef = FirebaseDatabase.getInstance().getReference().child("ServiceProviders");
        //Track changes of the values in the database
        serviceDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Regservice info = snapshot.getValue(Regservice.class);
                    //Retrieve the data from realtime database and populate it to a String.
                    String txt = "firstname: " + info.getFirstname() + "; \nlastname: " + info.getLastname() + "; \nemail: " + info.getEmail() + "; \nService Offering: " +
                            info.getServiceoffering() + "; \ncertificant Number: " + info.getCertnumber() + "; \nIdentity No: " + info.getIdentity() +
                            "; \nmobile No: " + info.getMobile() + "; \nlocation: " + info.getLocation();
                    //Add the string to the list
                    list.add(txt);
                }
                //Notify changes in the database.
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}