package com.example.takethechange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button9;
    private Button button8;
    private Button button7;
    private Button button6;
    private Button button5;
    private Button button4;
    private Button button3;
    private Button button2;
    private Button button1;
    private Button button0;
    private Button buttonClear;
    private TextView Taka;

    private TextView change500;
    private TextView change100;
    private TextView change50;
    private TextView change20;
    private TextView change10;
    private TextView change5;
    private TextView change2;
    private TextView change1;
    public String resultTaka="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // FROM HERE!!!
        findViews();
        setupButtonClockListener();

        if (savedInstanceState !=null) {
            String getBackTaka = savedInstanceState.getString("resultTaka");
            makeChange(getBackTaka);
        }
    }
    private void findViews(){
        Taka = findViewById(R.id.text_view_taka);
        button9 = findViewById(R.id.button_9);
        button8 = findViewById(R.id.button_8);
        button7 = findViewById(R.id.button_7);
        button6 = findViewById(R.id.button_6);
        button5 = findViewById(R.id.button_5);
        button4 = findViewById(R.id.button_4);
        button3 = findViewById(R.id.button_3);
        button2 = findViewById(R.id.button_2);
        button1 = findViewById(R.id.button_1);
        button0 = findViewById(R.id.button_0);
        buttonClear = findViewById(R.id.button_clear);
        change500 = findViewById(R.id.text_view_500);
        change100 = findViewById(R.id.text_view_100);
        change50 = findViewById(R.id.text_view_50);
        change20 = findViewById(R.id.text_view_20);
        change10 = findViewById(R.id.text_view_10);
        change5 = findViewById(R.id.text_view_5);
        change2 = findViewById(R.id.text_view_2);
        change1 = findViewById(R.id.text_view_1);
    }
    private void makeClear(){
        resultTaka = "";
        Taka.setText("Taka:");
        change500.setText("500:0");
        change100.setText("100:0");
        change50.setText("50:0");
        change20.setText("20:0");
        change10.setText("10:0");
        change5.setText("5:0");
        change2.setText("2:0");
        change1.setText("1:0");
    }
    public void makeChange(String number){
        resultTaka = resultTaka+number;
        Taka.setText("Taka:"+resultTaka);
        int resultInteger = Integer.parseInt(resultTaka);
        int change = (int)(Math.ceil(resultInteger*1));
        int taka500 = Math.round((int)change/500);
        change500.setText("500:"+String.valueOf(taka500));
        change = change%500;
        int taka100 = Math.round((int)change/100);
        change100.setText("100:"+String.valueOf(taka100));
        change = change%100;
        int taka50 = Math.round((int)change/50);
        change50.setText("50:"+String.valueOf(taka50));
        change = change%50;
        int taka20 = Math.round((int)change/20);
        change20.setText("20:"+String.valueOf(taka20));
        change = change%20;
        int taka10 = Math.round((int)change/10);
        change10.setText("10:"+String.valueOf(taka10));
        change = change%10;
        int taka5 = Math.round((int)change/5);
        change5.setText("5:"+String.valueOf(taka5));
        change=change%5;
        int taka2 = Math.round((int)change/2);
        change2.setText("2:"+String.valueOf(taka2));
        change=change%2;
        int taka1 = Math.round((int)change/1);
        change1.setText("1:"+String.valueOf(taka1));
//            change=change%1;
    }
    private void setupButtonClockListener(){
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeChange("9");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeChange("8");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeChange("7");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeChange("6");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeChange("5");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeChange("4");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeChange("3");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeChange("2");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeChange("1");
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeChange("0");
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeClear();
            }
        });
    }
    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("resultTaka",resultTaka);
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.getString("resultTaka");
    }
}