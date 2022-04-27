package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Mypage extends AppCompatActivity {
   TextView tvDate;
    LinearLayout container;
    Button bt_repair_registration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bt_repair_registration = findViewById(R.id.button2);

        setContentView(R.layout.activity_mypage);

        container = (LinearLayout) findViewById(R.id.linear_1);
        // 디자인 변수 초기화
        tvDate = (TextView) findViewById(R.id.tv_Date);
        // Text에 시간 세팅
        tvDate.setText(getTime());

        bt_repair_registration.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Mypage.this,Repair_Register.class);
                        startActivity(intent);
                    }
                }
        );

    }

    private String getTime() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String getTime = dateFormat.format(date);
        return getTime;
    }


    private void createTextView(){ //TextView 자동 생성 부분

        TextView textView = new TextView(getApplicationContext());

        textView.setText("Test");
        textView.setTextSize(12);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setId(0);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        lp.gravity = Gravity.CENTER;
        textView.setLayoutParams(lp);
        container.addView(textView);
    }

}