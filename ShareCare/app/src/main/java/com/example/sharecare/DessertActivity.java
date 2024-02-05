package com.example.sharecare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DessertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dessert);

        ListView dessertsList = findViewById(R.id.list_view_dessert);

        Dish[] desserts = {
                new Dish("Dark Forest Cake","Chocolate Cake",150),
                new Dish("Red Velvet Cake", "Red Valvet Cake", 140),
                new Dish("Strawberry Cake", "Strawberry Cake", 125),
                new Dish("Raspberry cake", "Raspberry cake", 160),
                new Dish("Chocolate Ice Cream", "Chocolate Ice Cream", 120),
                new Dish("Vanilla Ice Cream", "Vanilla Ice Cream",120),
                new Dish("Mixed Ice Cream", "Mixed Ice Cream", 125),
                new Dish("Strawberry Ice Cream With Cherry on top", "Strawberry Ice Cream With Cherry on top", 150),
                new Dish("Brownie with Ice Cream", "Brownie with Ice Cream", 220),
                new Dish("Brownie with Ice Cream and Caramel", "Brownie with Ice Cream and Caramel", 250)
        };

        ArrayAdapter<Dish> dishesAdapter = new ArrayAdapter<>(this, R.layout.custom_list_view, R.id.custom_text_view, desserts);
        dessertsList.setAdapter(dishesAdapter);

    }

}