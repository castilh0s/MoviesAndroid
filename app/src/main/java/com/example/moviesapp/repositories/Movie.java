package com.example.moviesapp.repositories;

import java.io.Serializable;

public class Movie implements Serializable {
    private Integer scene;
    private Integer poster;
    private String title;
    private String date;
    private String sinopsis;

    public Movie(Integer scene, Integer poster, String title, String date, String sinopsis) {
        this.scene = scene;
        this.poster = poster;
        this.title = title;
        this.date = date;
        this.sinopsis = sinopsis;
    }

    public Integer getScene() {
        return scene;
    }

    public Integer getPoster() {
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
