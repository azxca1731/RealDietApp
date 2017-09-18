package org.androidtown.dietapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

/**
 * Created by zidru on 2017-09-18.
 */

public class ChartActivity extends Activity {
    Button button_main;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        CalendarView calendar = (CalendarView) findViewById(R.id.calendar);
        button_main=(Button)findViewById(R.id.button_main);
        //리스너
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Intent intent = new Intent(ChartActivity.this, ViewCalendarActivity.class);
                intent.putExtra("Year", year);
                intent.putExtra("Month", month);
                intent.putExtra("Day", dayOfMonth);

                startActivity(intent);
            }
        });
        //리스너
        button_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
