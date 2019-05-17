package com.example.moviesapp.models;

import com.google.gson.annotations.SerializedName;

public class Genre {
    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    public Genre(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
