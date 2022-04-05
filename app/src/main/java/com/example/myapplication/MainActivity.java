package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    Button bt1;
    Spinner spinner;
    EditText ed1, ed2;
    int chk, price, lcchangetotal = 0, partchangetotal = 0, count = 0, total = 0, nyear;
    String myData, select = "";
    ArrayList<String> myData_2 = new ArrayList<>();
    HashMap<Integer, Integer> lcchangehm = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> partchangehm = new HashMap<Integer, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.button);
        ed1 = findViewById(R.id.ed_1);
        ed2 = findViewById(R.id.ed_2);
        spinner = findViewById(R.id.spinner);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nIntnet = new Intent(getApplicationContext(), MainActivity2.class);
                myData = ed1.getText().toString();
                price = Integer.parseInt(ed2.getText().toString());
                total += price;
                if (!myData_2.contains(myData))
                    myData_2.add(myData);
                nyear = Integer.parseInt(myData);
                nIntnet.putExtra("nyear", nyear);
                nIntnet.putExtra("data", myData_2);
                nIntnet.putExtra("chk", chk);
                nIntnet.putExtra("total", total);
                nIntnet.putExtra("lcchangehm", lcchangehm);
                nIntnet.putExtra("partchangehm",partchangehm);
                if(chk==0){
                    if (lcchangehm.containsKey(nyear)) {
                        lcchangetotal = 0;
                        lcchangetotal = lcchangehm.get(nyear) + price;
                        lcchangehm.remove(nyear);
                        lcchangehm.put(nyear, lcchangetotal);
                    } else {
                        lcchangehm.put(nyear, price);
                        partchangehm.put(nyear, 0);
                    }
                }
                if(chk==1){
                    if(partchangehm.containsKey(nyear)){
                        partchangetotal=0;
                        partchangetotal = partchangehm.get(nyear) + price;
                        partchangehm.remove(nyear);
                        partchangehm.put(nyear, partchangetotal);
                    }
                    else{
                        partchangehm.put(nyear,price);
                        lcchangehm.put(nyear,0);
                    }
                }
                count += 1;
                nIntnet.putExtra("count", count);
                for (int i = 0; i < myData_2.size(); i++) {
                    nIntnet.putExtra(myData_2.get(i) + "lcchangetotal", lcchangetotal);
                    nIntnet.putExtra(myData_2.get(i) + "partchangetotal", partchangetotal);
                }
                startActivityResult.launch(nIntnet);

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                select = spinner.getSelectedItem().toString();
                if (select.equals("액정교체")) {
                    chk = 0;

                } else {
                    chk = 1;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

        ActivityResultLauncher<Intent> startActivityResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            Intent nIntent = result.getData();
                            myData_2 = (nIntent.getStringArrayListExtra("data"));
                        }

                    }
                }
        );

    }

