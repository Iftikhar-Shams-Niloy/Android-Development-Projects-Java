package com.example.sharecare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StartersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starters);

        ListView startersList = findViewById(R.id.list_view_starters);


        Dish[] dishesArray = {
                new Dish("Thai Soup", "Thai Soup description", 250),
                new Dish("Corn Soup","Corn Soup",270),
                new Dish("Miso Soup","Miso Soup", 300),
                new Dish("Chicken Wontons","Chicken Wontons", 285),
                new Dish("Coconut and Chocolate Mousse","Coconut and Chocolate Mousse", 350),
                new Dish("Melon and Lemon Soup","Melon and Lemon Soup", 275),
                new Dish("Chikpea and Chili Gyoza","Chikpea and Chili Gyoza",400),
                new Dish("Pasta and Broccoli Soup","Pasta and Broccoli Soup",325),
                new Dish("Potato and Courgette Soup","Potato and Courgette Soup",360),
                new Dish("Pear and Chestnut Soup","Pear and Chestnut Soup",295),
                new Dish("Peppercorn and Tamarind Soup","Peppercorn and Tamarind Soup", 230)
        };

        ArrayAdapter<Dish> dishesAdapter = new ArrayAdapter<>(this, R.layout.custom_list_view, R.id.custom_text_view, dishesArray);
        startersList.setAdapter(dishesAdapter);

    };

}