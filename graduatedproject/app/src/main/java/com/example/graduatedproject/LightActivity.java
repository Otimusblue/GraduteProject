package com.example.graduatedproject;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LightActivity extends AppCompatActivity {

    Button turnLightOn, turnLightOff;
    DatabaseReference rootRef,demoRef;
    ImageView bulb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.light_acitivity);

        turnLightOn = (Button) findViewById(R.id.turn_on);
        turnLightOff = (Button) findViewById(R.id.turn_off);
        bulb = (ImageView) findViewById(R.id.bulb);

        //database reference pointing to root of database
        rootRef = FirebaseDatabase.getInstance().getReference();

        //database reference pointing to demo node


        turnLightOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    rootRef.child("LED_STATUS").setValue("ON");
                    bulb.setImageResource(R.drawable.bulb_on);
                    Toast.makeText(LightActivity.this, "Turn on the light!",
                            Toast.LENGTH_LONG).show();
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
                    bulb.setImageResource(R.drawable.bulb_off);
                    Toast.makeText(LightActivity.this, "Turn off the light!",
                            Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
