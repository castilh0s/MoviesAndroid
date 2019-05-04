package com.example.moviesapp.repositories;

public class Movie {
    private String scene;
    private String poster;
    private String title;
    private String date;
    private String sinopsis;

    public Movie(String scene, String poster, String title, String date, String sinopsis) {
        this.scene = scene;
        this.poster = poster;
        this.title = title;
        this.date = date;
        this.sinopsis = sinopsis;
    }

    public String getScene() {
        return scene;
    }

    public String getPoster() {
        return poster;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getSinopsis() {
        return sinopsis;
    }
}
