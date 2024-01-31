package com.example.convertertool;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText inchesEditText;
    EditText feetEditText;
    TextView resultTextView;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inchesString = inchesEditText.getText().toString();
                String feetString = feetEditText.getText().toString();
//                int feetInt = Integer.parseInt(feetString);
                if (inchesString.isEmpty() || feetString.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please, fill up all the fields!",Toast.LENGTH_SHORT).show();
                } else{
                    double result = calculateHeight(feetString, inchesString);
                    displayResult(result);

                }
            }
        });
    }
    private double calculateHeight(String feetString, String inchesString){
        int feetInt = Integer.parseInt(feetString);
        int inchesInt = Integer.parseInt(inchesString);
        return ((feetInt*12) + inchesInt)*0.0254;
    }
    private void findViews(){
        inchesEditText = findViewById(R.id.edit_text_inches);
        feetEditText = findViewById(R.id.edit_text_feet);
        calculateButton = findViewById(R.id.button_calculate);
        resultTextView = findViewById(R.id.text_view_result);
    }
    private void displayResult(double result) {
        DecimalFormat myFormat = new DecimalFormat("0.00");
        String resultString = myFormat.format(result);
        resultTextView.setText("Your Height\n"+resultString+"m");
    }
}