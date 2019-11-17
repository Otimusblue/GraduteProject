package com.example.graduatedproject;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button btnControlLight,btnFeed;
    DatabaseReference rootRef,demoRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnControlLight = (Button) findViewById(R.id.control_light);
        btnFeed = (Button) findViewById(R.id.feed_fish);

        btnControlLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        btnFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });

        //database reference pointing to root of database
        rootRef = FirebaseDatabase.getInstance().getReference();

        //database reference pointing to demo node
    }



    public void openActivity2() {
        Intent intent = new Intent(this.getApplicationContext(), SecondActivity.class);
        startActivity(intent);
    }
    public void openActivity3() {
        Intent intent = new Intent(this.getApplicationContext(), ThirdActivity.class);
        startActivity(intent);
    }

}



