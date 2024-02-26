package com.example.myanimewatchlist;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder> {
    private Anime[] animes;
    public AnimeAdapter(Anime[] animes){
        this.animes = animes;
    }
    @Override
    public int getItemCount() {
        return animes.length;
    }
    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anime, parent, false); // INFLATE
        return new AnimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        holder.bind(animes[position]);
    }



    static class AnimeViewHolder extends RecyclerView.ViewHolder{
        private ImageView animeImage;
        private TextView animeEpisode;
        private TextView animeTitle;
        private TextView animeDescription;
        public AnimeViewHolder(@NonNull View itemView) {
            super(itemView);
            animeImage = itemView.findViewById(R.id.image_view_project_icon);
            animeTitle = itemView.findViewById(R.id.text_view_title);
            animeDescription = itemView.findViewById(R.id.text_view_description);
            animeEpisode = itemView.findViewById(R.id.text_view_episode);
        }
        public void bind(Anime anime){
            animeTitle.setText(anime.name);
            animeDescription.setText(anime.description);
            animeImage.setImageResource(anime.image);
            animeEpisode.setText(anime.episode);
        }

    }

}

