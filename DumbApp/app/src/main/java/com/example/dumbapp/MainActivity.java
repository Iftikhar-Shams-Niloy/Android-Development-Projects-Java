package com.example.dumbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView score;
    private TextView question;
    private Button wrongButton;
    private Button rightButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        question.setText(getNumber());
    }
    private void findViews(){
        score = findViewById(R.id.text_view_score);
        question = findViewById(R.id.text_view_question);
        wrongButton = findViewById(R.id.button_wrong);
        rightButton = findViewById(R.id.button_right);
    }

//    private void setupButtonClickListener(){
//        wrongButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        rightButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//    }

    private String getNumber(){
        Random rand = new Random();
        int num1 = rand.nextInt(50);
        int num2 = rand.nextInt(50);
        int realResult = num1 + num2;
        int fakeResult = realResult + rand.nextInt(50);
        int finalResult = rand.nextBoolean()?realResult:fakeResult;
        String num1String = String.valueOf(num1);
        String num2String = String.valueOf(num2);
        String resultString = String.valueOf(finalResult);
        String finalResultString = num1String+" + "+num1String+" = "+resultString;
        return finalResultString;
    }
}