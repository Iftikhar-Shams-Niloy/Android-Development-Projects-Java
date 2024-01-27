package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    // Class Variables are also called 'Fields'
    private TextView resultText;
    private TextView statusText;
    private TextView reviewText;
    private Button calculateButton;
    private RadioButton radioMale;
    private View radioFemale;
    private EditText ageEditText;
    private EditText feetEditText;
    private EditText inchesEditText;
    private EditText weightEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClockListener();
    }

    private void findViews(){
        resultText = findViewById(R.id.text_view_result);
        statusText = findViewById(R.id.text_view_status);// resultText now a class variable
        reviewText = findViewById(R.id.text_view_review);
        calculateButton = findViewById(R.id.button_calculate);

        radioMale = findViewById(R.id.radio_button_male);
        radioFemale = findViewById(R.id.radio_button_female);

        ageEditText = findViewById(R.id.edit_text_age);
        feetEditText = findViewById(R.id.edit_text_feet);
        inchesEditText = findViewById(R.id.edit_text_inches);
        weightEditText = findViewById(R.id.edit_text_weight);
    }

    private void setupButtonClockListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bmiResult = calculateBMI();
                showResult(bmiResult);
                Toast.makeText(MainActivity.this,"Your BMI is being Calculated!",Toast.LENGTH_SHORT).show(); // Use to show pop-up message!
            }
        });
    }

    private double calculateBMI(){
        String ageText = ageEditText.getText().toString();
        String feetText = feetEditText.getText().toString();
        String inchesText = inchesEditText.getText().toString();
        String weightText = weightEditText.getText().toString();

        int ageInteger = Integer.parseInt(ageText);
        int feetInteger = Integer.parseInt(feetText);
        int inchesInteger = Integer.parseInt(inchesText);
        int weightInteger = Integer.parseInt(weightText);
        int totalInch = (feetInteger * 12) + inchesInteger;
        double heightMeters = totalInch * 0.0254;

        statusText.setText("||| Your Status |||\nAge: "+ ageText +" \nHeight: "+ feetText +"' "+ inchesText + "''\nWeight: " + weightText);

        return weightInteger/ (heightMeters * heightMeters);
    }

    private void showResult(double bmiTotal){
        DecimalFormat myDecimalFormat = new DecimalFormat("0.00");
        String bmiResultText = myDecimalFormat.format(bmiTotal);

        String review;

        if (bmiTotal < 18.5) {
            review = "You are UNDERWEIGHT!";
        } else if (bmiTotal >= 18.5 && bmiTotal <=24.9) {
            review = "Your weight is HEALTHY!";
        } else if (bmiTotal >= 25 && bmiTotal <= 29.9){
            review = "You are OVERWEIGHT!";
        } else if (bmiTotal >= 30 && bmiTotal <= 34.9) {
            review = "You are OBESE!";
        } else {
            review = "You are NOT HUMAN!!!";
        }

        resultText.setText("Your BMI : " + bmiResultText);
        reviewText.setText(review);

    }

}