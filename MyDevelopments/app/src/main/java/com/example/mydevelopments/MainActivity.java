package com.example.mydevelopments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView list = findViewById(R.id.recycler_view_projects);

        Development[] developments = {
            new Development("First app", "This is my First app", R.drawable.ic_launcher_background),
            new Development("BMI Calculator", "This is my Second app", R.drawable.bmi_app_logo),
            new Development("Converter Tool", "This is my Third app", R.drawable.converter_tools_logo),
            new Development("Take The Change", "This is my Fourth app", R.drawable.take_the_change_app),
            new Development("Share and Care", "This is my Fifth app", R.drawable.ic_launcher_foreground),
        };

        DevelopmentsAdapter adapter = new DevelopmentsAdapter(developments);

        list.setAdapter(adapter);

    }


}