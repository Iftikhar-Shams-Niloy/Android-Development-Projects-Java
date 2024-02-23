package com.example.myanimewatchlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class AnimeDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_details);

        String name = getIntent().getStringExtra("NAME");
        String description = getIntent().getStringExtra("DESCRIPTION");
        String episode = getIntent().getStringExtra("EPISODE");
        int image = getIntent().getIntExtra("IMAGE", 0);
        float star = getIntent().getFloatExtra("STAR", 0);

        TextView nameText = findViewById(R.id.text_view_name);
        TextView descriptionText = findViewById(R.id.text_view_description);
        TextView epoisodeText = findViewById(R.id.text_view_episode);
        ImageView posterImage = findViewById(R.id.image_view_image);
        RatingBar rateBar = findViewById(R.id.rating_bar);

        nameText.setText(name);
        descriptionText.setText(description);
        epoisodeText.setText(episode);
        posterImage.setImageResource(image);
        rateBar.setRating(star);
    }
}