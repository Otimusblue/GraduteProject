package com.example.graduatedproject;

import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TempActivity extends AppCompatActivity {

    DatabaseReference rootRef;
    EditText tempValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        rootRef = FirebaseDatabase.getInstance().getReference();
        tempValue = (EditText) findViewById(R.id.tempValue);
        getData();
    }

    private void getData(){

            rootRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Double temper = (Double) dataSnapshot.child("TEMPER").getValue();
                        tempValue.setText(""+temper+"ºC");
            }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
                });
        }
    }



