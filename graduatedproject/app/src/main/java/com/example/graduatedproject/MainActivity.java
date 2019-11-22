package com.example.graduatedproject;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView lightCard,feedCard,tempCard,timingCard;
    Button btnControlLight,btnFeed;
    DatabaseReference rootRef,demoRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //defining card
        lightCard = (CardView) findViewById(R.id.light_card);
        feedCard = (CardView) findViewById(R.id.feed_card);
        tempCard = (CardView) findViewById(R.id.temperature_card);
        timingCard = (CardView) findViewById(R.id.schedule_card);
        //add Click Listener to this cards
        lightCard.setOnClickListener(this);
        feedCard.setOnClickListener(this);
        tempCard.setOnClickListener(this);
        timingCard.setOnClickListener(this);



//        btnControlLight = (Button) findViewById(R.id.control_light);
//        btnFeed = (Button) findViewById(R.id.feed_fish);

//        btnControlLight.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openActivity2();
//            }
//        });
//        btnFeed.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    rootRef.child("SERVO").setValue("ON");
//                    Toast.makeText(MainActivity.this, "Feed the fishs!",
//                            Toast.LENGTH_LONG).show();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        //database reference pointing to root of database
        rootRef = FirebaseDatabase.getInstance().getReference();

        //database reference pointing to demo node
    }



    public void openActivity2() {
        Intent intent = new Intent(this.getApplicationContext(), LightActivity.class);
        startActivity(intent);
    }
    public void openActivity3() {
        Intent intent = new Intent(this.getApplicationContext(), FeedActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.light_card : i = new Intent(this,LightActivity.class);startActivity(i);break;
            case R.id.feed_card : i = new Intent(this, FeedActivity.class);startActivity(i); break;
            case R.id.temperature_card : i = new Intent(this, TempActivity.class);startActivity(i); break;
            case R.id.schedule_card : i = new Intent(this, TimingActivity.class);startActivity(i); break;
            default:break;
        }
    }
}



