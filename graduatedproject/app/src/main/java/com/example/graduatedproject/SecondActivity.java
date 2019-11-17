package com.example.graduatedproject;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SecondActivity extends AppCompatActivity {

    Button turnLightOn, turnLightOff;
    DatabaseReference rootRef,demoRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_acitivity);

        turnLightOn = (Button) findViewById(R.id.turn_on);
        turnLightOff = (Button) findViewById(R.id.turn_off);

        //database reference pointing to root of database
        rootRef = FirebaseDatabase.getInstance().getReference();

        //database reference pointing to demo node


        turnLightOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    rootRef.child("LED_STATUS").setValue("ON");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        turnLightOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    rootRef.child("LED_STATUS").setValue("OFF");
                    //  rootRef.child("devices").updateChildren({'light1': "true" });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
