package com.example.sharecare;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainCoursesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_courses);

        ListView mainCoursesList = findViewById(R.id.list_view_main_courses);

        Dish[] mainCourses = {
                new Dish("Chicken Biryani","Chicken Biryani sheraaa!",450),
                new Dish("Morog Polao", "Morog Polao Shei tasty!!!", 420),
                new Dish("Beef Teheri", "Ek bar khaile bar bar khaben!", 495),
                new Dish("Grill and Nun", "Khete hebby taste, khawar por shonar Bangladesh", 380),
                new Dish("Chicken Fried Rice", "Ken jaani, shobai khaite pochondo kore", 310),
                new Dish("Prawn Fried Rice", "Better than Chicken FR but, no body cares to try",320),
                new Dish("Beef Curry and Rice", "Bangali hoile apnar bhalo laagbei", 270),
                new Dish("Mutton Curry and Rice", "Ekbar khaile, khaiben shoto-bar", 280),
                new Dish("Dori Fish Fry", "Looks amazing, tastes even better", 290),
                new Dish("Butter Chicken with Parathas", "Khaben ar shudhu mota hoben", 280)
        };

        ArrayAdapter<Dish> dishesAdapter = new ArrayAdapter<>(this, R.layout.custom_list_view, R.id.custom_text_view, mainCourses);
        mainCoursesList.setAdapter(dishesAdapter);

    }
}
