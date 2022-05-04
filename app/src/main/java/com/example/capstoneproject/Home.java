package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    Button registration;
    ImageView imgv_mypage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        registration = findViewById(R.id.button3);
        imgv_mypage = findViewById(R.id.imageView5);

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(Home.this,Register_Search_1.class);
                //하위 코드 실행을 위한 입시 주석
                //startActivity(intent);

                //임시 코드 시작
                HorizontalScrollView horizontalScrollView = (HorizontalScrollView) findViewById(R.id.con);
                LayoutInflater vi	= (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                View vi_view= vi.inflate(R.layout.activity_test, null,false);

//                RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//
//                vi_view.setLayoutParams(p);
                horizontalScrollView.addView(vi_view);//error
                //setContentView(vi_view); 뷰 이동
                //임시 코드 끝
            }
        });

        imgv_mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,Mypage.class);

                startActivity(intent);
            }
        });

    }
}