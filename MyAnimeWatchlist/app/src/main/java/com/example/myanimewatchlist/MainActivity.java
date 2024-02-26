package com.example.myanimewatchlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView list = findViewById(R.id.recycler_view_anime);

        Anime[] allAnimes = {
                new Anime("One Piece",
                        "This is my First app", R.drawable.onepiece_poster, "1000+"),
                new Anime("Demon Slayer",
                        "This is my Second app", R.drawable.demonslayer_poster, "50+"),
                new Anime("Naruto",
                        "This is my Second app", R.drawable.naruto_poster,"800"),
                new Anime("Jujutsu Kaisen",
                        "This is my Third app", R.drawable.jujutsu_poster,"48"),
                new Anime("Solo Leveling",
                        "This is my Fourth app", R.drawable.sololeveling_poster,"6+"),
                new Anime("Attack on Titan",
                        "This is my Fifth app", R.drawable.aot_poster,"100+"),
                new Anime("My Hero Academia",
                        "This is my Sixth app", R.drawable.mha_poster,"100+"),
                new Anime("Black Clover",
                        "DUMMY app", R.drawable.blackclover_poster,"170+"),
                new Anime("Fairy Tail",
                        "DUMMY app", R.drawable.fairytail_poster,"270+"),
                new Anime("Heavenly Delusion",
                        "DUMMY app", R.drawable.heavenlydelusion_poster,"24"),
                new Anime("Made in Abyss",
                        "DUMMY app", R.drawable.madeinabyss_poster,"24"),
                new Anime("The Promised Neverland",
                        "DUMMY app", R.drawable.promisedneverland_poster,"24"),
                new Anime("Vinland Saga",
                        "DUMMY app", R.drawable.vinland_poster,"24"),
        };

        AnimeAdapter myAdapter = new AnimeAdapter(allAnimes);

        list.setAdapter(myAdapter);

    }
}