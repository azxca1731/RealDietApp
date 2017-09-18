package org.androidtown.dietapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button userInfo_btn;
    Button menu_btn;
    Button chart_btn;
    Button plus_btn;
    Button minus_btn;
    ProgressBar calorie_pbar;
    TextView percentage_view;
    int progress;
    View.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInfo_btn=(Button) findViewById(R.id.btn_userinfo);
        menu_btn=(Button)findViewById(R.id.btn_menu);
        chart_btn=(Button)findViewById(R.id.btn_chart);
        plus_btn=(Button)findViewById(R.id.btn_plus);
        minus_btn=(Button)findViewById(R.id.btn_minus);
        calorie_pbar=(ProgressBar)findViewById(R.id.pbar_calorie);
        percentage_view=(TextView)findViewById(R.id.view_percentage);
        progress=0;

        listener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch (v.getId())
                {
                    case R.id.btn_userinfo:
                        break;
                    case R.id.btn_menu:
                        break;
                    case R.id.btn_chart:
                        break;
                    case R.id.btn_plus:
                        if (progress<100)
                        {
                            progress++;
                            percentage_view.setText(progress+"%");
                            calorie_pbar.setProgress(progress);
                        }
                        break;
                    case R.id.btn_minus:
                        if(progress>0)
                        {
                            progress--;
                            percentage_view.setText(progress+"%");
                            calorie_pbar.setProgress(progress);
                        }
                        break;
                }
            }
        };
        userInfo_btn.setOnClickListener(listener);
        menu_btn.setOnClickListener(listener);
        chart_btn.setOnClickListener(listener);
        plus_btn.setOnClickListener(listener);
        minus_btn.setOnClickListener(listener);
    }
}
