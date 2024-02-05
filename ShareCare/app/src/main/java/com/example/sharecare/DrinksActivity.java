package com.example.sharecare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_drinks);

        ListView drinksList = findViewById(R.id.list_view_drinks);

        Dish[] drinks = {
                new Dish("Blue Lagoon", "blue lagoon is great", 220),
                new Dish("Lava Bloom", "Lava bloom is a made up name", 240),
                new Dish("Coconut Shake", "Coconut shake is tasty", 200),
                new Dish("Hot Chocolate", "Hot chocolate is great", 250),
                new Dish("Hot Coffee: Americano", "Americano is my favorite", 140),
                new Dish("Iced Coffee: Latte", "Iced Latte is good", 280),
                new Dish("Iced Coffee: Mocha", "Iced mocha is great",300),
                new Dish("Coca-Cola 250ml", "Coca-cola is great", 50),
                new Dish("Pepsi 250ml", "Pepsi is great", 50),
                new Dish("Mountain Dew 250ml", "Mountain dew is great", 50),
                new Dish("7up 250ml", "7up is great", 50),
                new Dish("Mojo 500ml", "Mojo is amazing",50),
                new Dish("Lemu 500ml", "Lemu is amazing", 50),
                new Dish("Clemon 500ml", "Clemon is amazing", 50)
        };

        ArrayAdapter<Dish> drinksAdapter = new ArrayAdapter<>(this, R.layout.custom_list_view,R.id.custom_text_view, drinks);
        drinksList.setAdapter(drinksAdapter);

    }

}