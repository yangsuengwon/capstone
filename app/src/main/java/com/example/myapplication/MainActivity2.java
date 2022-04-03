package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class MainActivity2 extends AppCompatActivity {

    Button bt2;
    TextView tv2,tv3,tv4;
    String myData="",year,data;
    int price,chk,lcchangetotal=0,partchangetotal=0,total=0,count;
    ArrayList<String> myData_2=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv2=findViewById(R.id.textView2);
        bt2=findViewById(R.id.button2);
        tv3=findViewById(R.id.textView3);
        tv4=findViewById(R.id.textView4);
        myData_2=getIntent().getStringArrayListExtra("data");
        price=getIntent().getIntExtra("price",0);
        total=getIntent().getIntExtra("total",0);
        total=total+price;
        chk=getIntent().getIntExtra("chk",0);
        year=getIntent().getStringExtra("year");
        count=getIntent().getIntExtra("count",0);
        data="";
        total+=price;
        Collections.sort(myData_2);
        for(int i=0;i<myData_2.size();i++){
            data+=myData_2.get(i)+"년"+"\n";
            data+="액정교체 0000원\n";
            data+="부품교체 0000원\n";
            data+="----------------------------------\n";
        }
        tv2.setText("A/S횟수는 "+count+"건이며,");
        tv3.setText("총 비용은 "+total+"원입니다.");
        tv4.setText(data);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nIntent=new Intent(getApplicationContext(),MainActivity.class);
                nIntent.putExtra("data",myData_2);
                nIntent.putExtra("count",count);
                nIntent.putExtra("year",year);
                nIntent.putExtra("total",total);
                setResult(RESULT_OK,nIntent);
                finish();
            }
        });
    }
}