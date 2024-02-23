package com.example.myanimewatchlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AnimeViewInterface{

    ArrayList<Anime> Anime = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView list = findViewById(R.id.recycler_view_anime);

        Anime[] allAnimes = {
                new Anime("One Piece",
                        "This is my First app", R.drawable.onepiece_poster, "1000+", 5),
                new Anime("Demon Slayer",
                        "This is my Second app", R.drawable.demonslayer_poster, "50+", 5),
                new Anime("Naruto",
                        "This is my Second app", R.drawable.naruto_poster,"800", 4.5f),
                new Anime("Jujutsu Kaisen",
                        "This is my Third app", R.drawable.jujutsu_poster,"48" ,5),
                new Anime("Solo Leveling",
                        "This is my Fourth app", R.drawable.sololeveling_poster,"6+", 5),
                new Anime("Attack on Titan",
                        "This is my Fifth app", R.drawable.aot_poster,"100+", 4.5f),
                new Anime("My Hero Academia",
                        "This is my Sixth app", R.drawable.mha_poster,"100+", 4),
                new Anime("Black Clover",
                        "DUMMY app", R.drawable.blackclover_poster,"170+",4.5f),
                new Anime("Fairy Tail",
                        "DUMMY app", R.drawable.fairytail_poster,"270+",3.5f),
                new Anime("Heavenly Delusion",
                        "DUMMY app", R.drawable.heavenlydelusion_poster,"24", 5),
                new Anime("Made in Abyss",
                        "DUMMY app", R.drawable.madeinabyss_poster,"24", 5),
                new Anime("The Promised Neverland",
                        "DUMMY app", R.drawable.promisedneverland_poster,"24", 4.5f),
                new Anime("Vinland Saga",
                        "DUMMY app", R.drawable.vinland_poster,"24",3.5f),
        };

        AnimeAdapter myAdapter = new AnimeAdapter(allAnimes, this);

        list.setAdapter(myAdapter);

    }
    @Override
    public void onItemClick(int position) { // This method does all the work when an Item of recycler view is clicked
        Intent intent = new Intent(MainActivity.this, AnimeDetailsActivity.class);
        intent.putExtra("NAME", Anime.get(position).getName());
        intent.putExtra("DESCRIPTION", Anime.get(position).getDescription());
        intent.putExtra("EPISODE", Anime.get(position).getEpisode());
        intent.putExtra("IMAGE", Anime.get(position).getImage());
        intent.putExtra("STAR", Anime.get(position).getStar());
    }
}