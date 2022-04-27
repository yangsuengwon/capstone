package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Register_Product extends AppCompatActivity {

    Button bt_submit;
    TextView tv_date;
    ImageButton imgbt_calender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_product);

        imgbt_calender = findViewById(R.id.bt_calender);

        bt_submit = findViewById(R.id.button);

        int year1 = 0,month1 = 0,day1 = 0;

        imgbt_calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register_Product.this,Product_Register_Popup.class);
                startActivity(intent);
            }
        });

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                tv_date.setText(dayOfMonth+"/" + (month+1) + "/" + year);
            }
        }
        , year1, month1, day1);
        imgbt_calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });


        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent(Register_Product.this,Home.class);
            }
        });
    }
}