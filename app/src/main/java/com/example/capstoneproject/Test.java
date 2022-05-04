package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class Test extends LinearLayout {

    public Test(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public Test(Context context) {
        super(context);

        init(context);
    }
    private void init(Context context){
        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_test,this,true);
    }

}