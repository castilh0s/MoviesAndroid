package com.example.moviesapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GenreList {
    @SerializedName("genres")
    private List<Genre> genres;

    public GenreList(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Genre> getGenres() {
        return genres;
    }
}
