package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class MainActivity2 extends AppCompatActivity {

    Button bt2;
    TextView tv2,tv3,tv4;
    String year,data;
    int total=0,count,nyear;
    ArrayList<String> myData_2=new ArrayList<>();
    HashMap<Integer,Integer> lcchangehm=new HashMap<Integer,Integer>();
    HashMap<Integer,Integer> partchangehm=new HashMap<Integer,Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv2=findViewById(R.id.textView2);
        bt2=findViewById(R.id.button2);
        tv3=findViewById(R.id.textView3);
        tv4=findViewById(R.id.textView4);
        myData_2=getIntent().getStringArrayListExtra("data");
        total=getIntent().getIntExtra("total",0);
        year=getIntent().getStringExtra("year");
        count=getIntent().getIntExtra("count",0);
        data="";
        lcchangehm.clear();
        lcchangehm=(HashMap<Integer, Integer>) getIntent().getSerializableExtra("lcchangehm");
        partchangehm=(HashMap<Integer, Integer>) getIntent().getSerializableExtra("partchangehm");
        Collections.sort(myData_2);
        for(int i=0;i<myData_2.size();i++){
            data+=myData_2.get(i)+"년"+"\n";
            nyear=Integer.parseInt(myData_2.get(i));
            data+="액정교체 "+lcchangehm.get(nyear)+"원\n";
            data+="부품교체 "+partchangehm.get(nyear)+"원\n";
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
                setResult(RESULT_OK,nIntent);
                finish();
            }
        });
    }
}