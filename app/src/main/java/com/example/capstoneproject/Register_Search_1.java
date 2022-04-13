package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Register_Search_1 extends AppCompatActivity {

    Button import_bt,search_bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_search_1);

        import_bt = findViewById(R.id.bt1);
        search_bt = findViewById(R.id.bt1_search);

        import_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register_Search_1.this, Register_Search_2.class);
                startActivity(intent);
            }
        });

        search_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}