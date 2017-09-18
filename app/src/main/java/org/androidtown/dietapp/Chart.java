package org.androidtown.dietapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;

/**
 * Created by zidru on 2017-09-18.
 */

public class Chart extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart);

        CalendarView calendar = (CalendarView) findViewById(R.id.calendar);
        //리스너
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Intent intent = new Intent(Chart.this, View_Calendar.class);
                intent.putExtra("Year", year);
                intent.putExtra("Month", month);
                intent.putExtra("Day", dayOfMonth);

                startActivity(intent);
            }
        });
    }
}
