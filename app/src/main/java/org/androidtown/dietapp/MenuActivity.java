package org.androidtown.dietapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    Button toMain_btn;
    View.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        toMain_btn = (Button)findViewById(R.id.btn_to_main);
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId())
                {
                    case R.id.btn_to_main:
                        finish();
                        break;
                }
            }
        };
        toMain_btn.setOnClickListener(listener);
    }
}
