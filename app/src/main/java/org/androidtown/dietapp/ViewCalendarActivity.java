package org.androidtown.dietapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by zidru on 2017-09-18.
 */

public class ViewCalendarActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_calender);

        Intent intent = getIntent();
        int yaer = intent.getExtras().getInt("Year");
        int month = intent.getExtras().getInt("Month");
        int day = intent.getExtras().getInt("Day");

        Button button = (Button) findViewById(R.id.button_to_chart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
