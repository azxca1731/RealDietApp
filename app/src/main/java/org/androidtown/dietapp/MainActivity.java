package org.androidtown.dietapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.id.list;

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
    ListView history_view;
    ArrayList<String> arrHistory;
    ArrayAdapter<String> adapter;
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
        history_view=(ListView)findViewById(R.id.view_history);

      //리스트뷰에 보여줄 아이템을 추가하는 부분 지금은 예시라 스트링을 넣었음 추후에 db에서 가져온 오늘 먹은 음식의 이름을 추가하게 변경예정
        arrHistory = new ArrayList<>();
        arrHistory.add("Food1");
        arrHistory.add("Food2");
        arrHistory.add("Food3");

        //어댑터 객체화후 리스트뷰에 추가하는 부분
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrHistory);
        history_view.setAdapter(adapter);
        progress=0;

        //변경할 사항 리스트 뷰의 아이템을 눌렀을때 자세한 액티비티를 보여줄 부분이 필요함
        listener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch (v.getId())
                {
                    case R.id.btn_userinfo:
                        Intent AuthItent = new Intent(MainActivity.this,EmailPasswordActivity.class);
                        startActivity(AuthItent);
                        break;
                    case R.id.btn_menu:
                        break;
                    case R.id.btn_chart:
                    {
                        Intent chartIntent = new Intent(MainActivity.this,ChartActivity.class);
                        startActivity(chartIntent);
                    }
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
