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
    Button day_btn, set_light_on_btn,set_light_off_btn, set_feed_btn,submit_feed_button, submit_led_button;
    private int mYear,mMonth,mDay,mHour,mMinute,mHourLed,mMinuteLed;
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
        set_feed_btn = findViewById(R.id.set_feed_button);



        day_btn.setOnClickListener(this);
        set_light_on_btn.setOnClickListener(this);
        set_light_off_btn.setOnClickListener(this);
        set_feed_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == day_btn){
            final Calendar calendar = Calendar.getInstance();
            mYear = calendar.get(Calendar.YEAR);
            mMonth = calendar.get(Calendar.MONTH);
            mDay = calendar.get(Calendar.DAY_OF_MONTH);


            final DatePickerDialog datePickerDialog = new DatePickerDialog(this,R.style.MyDatePickerDialogTheme, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    setTimeToDatabase = year+"-"+(month+1)+"-"+dayOfMonth;
                    day_edt.setText(dayOfMonth+"-"+(month+1)+"-"+year);

                }
            },mYear,mMonth,mDay);
            datePickerDialog.show();

        }
        if (v == set_feed_btn){
            final Calendar calendar = Calendar.getInstance();
            mHour = calendar.get(Calendar.HOUR);
            mMinute = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, R.style.MyTimePickerDialogTheme,new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    feed_on_edt.setText(String.format("%02d:%02d", hourOfDay, minute));
                    rootRef.child("SCHEDULE/FEED/SET_ON").setValue(setTimeToDatabase+"T"+String.format("%02d:%02d", hourOfDay, minute));
                }
            },mHour,mMinute,true);
            timePickerDialog.show();



        }
        if (v == set_light_on_btn) {
            final Calendar calendar = Calendar.getInstance();
            mHourLed = calendar.get(Calendar.HOUR);
            mMinuteLed = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialogLed = new TimePickerDialog(this, R.style.MyTimePickerDialogTheme,new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    light_on_edt.setText(String.format("%02d:%02d", hourOfDay, minute));
                    rootRef.child("SCHEDULE/LED/SET_ON").setValue(setTimeToDatabase+"T"+String.format("%02d:%02d", hourOfDay, minute));
                }
            },mHourLed,mMinuteLed,true);
            timePickerDialogLed.show();

        }
        if (v == set_light_off_btn){
            final Calendar calendar = Calendar.getInstance();
            mHourLed = calendar.get(Calendar.HOUR);
            mMinuteLed = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialogLedOff = new TimePickerDialog(this, R.style.MyTimePickerDialogTheme,new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    light_off_edt.setText(String.format("%02d:%02d", hourOfDay, minute));
                    rootRef.child("SCHEDULE/LED/SET_OFF").setValue(setTimeToDatabase+"T"+String.format("%02d:%02d", hourOfDay, minute));
                }
            },mHourLed,mMinuteLed,true);
            timePickerDialogLedOff.show();

        }

    }



}
