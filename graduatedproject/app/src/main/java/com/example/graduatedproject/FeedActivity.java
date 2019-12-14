package com.example.graduatedproject;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedActivity extends AppCompatActivity {

    DatabaseReference rootRef;
    Button btnFeed,rsFeed;
    TextView tvFeed;
    String set_feed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        btnFeed = findViewById(R.id.feed_button);
        rsFeed = findViewById(R.id.reset_button);
        rootRef = FirebaseDatabase.getInstance().getReference();
        tvFeed = findViewById(R.id.tv_feed);

        btnFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                                        rootRef.child("SERVO").setValue("ON");
                                        tvFeed.setText("Your fishes are full.");
                                        btnFeed.setEnabled(false);
                                        Toast.makeText(FeedActivity.this, "Feed the fishs!",
                                                Toast.LENGTH_LONG).show();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
            }
        });
        rsFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    rootRef.child("SERVO").setValue("OFF");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        tvFeed.setText("Your fishes are hungry now. Do you want to feed ?");
        btnFeed.setEnabled(true);
        rootRef.child("SERVO").setValue("OFF");
    }
}
