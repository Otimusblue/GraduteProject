package com.example.graduatedproject;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.Calendar;

public class TimingActivity extends AppCompatActivity implements View.OnClickListener {

    EditText day_edt, light_on_edt, light_off_edt, feed_on_edt;
    Button day_btn, set_light_on_btn,set_light_off_btn, submit_light_btn, set_feed_btn,submit_feed_btn;
    private int mYear,mMonth,mDay,mHour,mMinute;
    String setTimeToDatabase;
    DatabaseReference rootRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timing);
        rootRef = FirebaseDatabase.getInstance().getReference();
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

        day_btn.setOnClickListener(this);
        set_light_on_btn.setOnClickListener(this);
        set_light_off_btn.setOnClickListener(this);
        set_feed_btn.setOnClickListener(this);
        submit_feed_btn.setOnClickListener(this);
        submit_light_btn.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        if (v == day_btn){
            final Calendar calendar = Calendar.getInstance();
            mYear = calendar.get(Calendar.YEAR);
            mMonth = calendar.get(Calendar.MONTH);
            mDay = calendar.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    setTimeToDatabase = dayOfMonth+"-"+(month+1)+"-"+year;
                    day_edt.setText(dayOfMonth+"-"+(month+1)+"-"+year);


                }
            },mYear,mMonth,mDay);
            datePickerDialog.show();
        }
        if (v == set_feed_btn){
            final Calendar calendar = Calendar.getInstance();
            mHour = calendar.get(Calendar.HOUR);
            mMinute = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    feed_on_edt.setText(hourOfDay+":"+ minute);
                }
            },mHour,mMinute,true);
            timePickerDialog.show();



            rootRef.child("SETTIME").setValue(setTimeToDatabase+""+mHour+mMinute);
            rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    new android.os.Handler().postDelayed(new Runnable() {
                                                             @Override
                                                             public void run() {
                                                                 rootRef.child("SETTIME").setValue("THANH CONG");
                                                             }
                                                         },
                            30*1000);
                }


                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
    }



}
