package com.example.graduatedproject;

import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class TimingActivity extends AppCompatActivity {

    EditText day_edt, light_on_edt, light_off_edt, feed_on_edt;
    Button day_btn, set_light_on_btn,set_light_off_btn, submit_light_btn, set_feed_btn,submit_feed_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timing);

        day_edt = findViewById(R.id.day_edt);
        light_on_edt = findViewById(R.id.set_on_edt);
        light_off_edt = findViewById(R.id.set_off_edt);
        feed_on_edt = findViewById(R.id.set_feed_edt);

        day_btn = findViewById(R.id.date_button);
        set_light_off_btn = findViewById(R.id.turn_off_button);
        set_light_on_btn = findViewById(R.id.turn_on_button);
        submit_light_btn = findViewById(R.id.submit_light);
        set_feed_btn = findViewById(R.id.set_feed_button);
        submit_feed_btn = findViewById(R.id.submit_feed_button);

        

    }
}
