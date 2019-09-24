package me.gsix.spoisy.test;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;

public class HolidayActivity extends AppCompatActivity {
    private HolidayModel holiday;
    private TextView name;
    private TextView date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday);

        name = findViewById(R.id.name);
        date = findViewById(R.id.date);
        holiday = (HolidayModel) getIntent().getExtras().getSerializable("holiday");
        name.setText(holiday.name);
        date.setText(String.format("%s/%s/%s",holiday.date,holiday.month,holiday.year));

    }

}
