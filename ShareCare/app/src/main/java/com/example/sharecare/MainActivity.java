package com.example.sharecare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CardView startersCard;
    CardView mainsCard;
    CardView dessertCard;
    CardView drinksCard;
    TextView emailAdress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startersCard = findViewById(R.id.card_view_starters);
        mainsCard = findViewById(R.id.card_view_main_course);
        dessertCard = findViewById(R.id.card_view_dessert);
        drinksCard = findViewById(R.id.card_view_drinks);
        startersCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startersActivityIntent = new Intent(MainActivity.this, StartersActivity.class);
                startActivity(startersActivityIntent);
            }
        });
        mainsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainsActivityIntent = new Intent(MainActivity.this, MainCoursesActivity.class);
                startActivity(mainsActivityIntent);
            }
        });
        dessertCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dessertActivityIntent = new Intent(MainActivity.this, DessertActivity.class);
                startActivity(dessertActivityIntent);
            }
        });
        drinksCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent drinksActivityIntent = new Intent(MainActivity.this, DrinksActivity.class);
                startActivity(drinksActivityIntent);
            }
        });

        TextView emailTextView = findViewById(R.id.text_view_email);
        emailTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent EmailAppIntent = new Intent(Intent.ACTION_SENDTO);
                EmailAppIntent.setData(Uri.parse("mailto:share.and.care5916@gmail.com")); // only email apps should handle this
                startActivity(EmailAppIntent );

            }
        });

    }
}