package com.example.myanimewatchlist;

public class Anime {
    String name;
    String description;
    String episode;
    int image;
    float star=0;


    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getEpisode() {
        return episode;
    }
    public int getImage() {
        return image;
    }
    public float getStar() {
        return star;
    }

    public Anime(String name, String description, int image, String episode, float star) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.episode = episode;
        this.star = star;
    }

}

