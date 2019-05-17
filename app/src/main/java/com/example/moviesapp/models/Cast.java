package com.example.moviesapp.models;

import com.google.gson.annotations.SerializedName;

public class Cast {
    @SerializedName("cast_id")
    private Integer castId;

    @SerializedName("character")
    private String character;

    @SerializedName("credit_id")
    private String creditId;

    @SerializedName("gender")
    private Integer gender;

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("order")
    private Integer order;

    @SerializedName("profile_path")
    private String profilePath;

    public Cast(Integer castId, String character, String creditId, Integer gender, Integer id, String name, Integer order, String profilePath) {
        this.castId = castId;
        this.character = character;
        this.creditId = creditId;
        this.gender = gender;
        this.id = id;
        this.name = name;
        this.order = order;
        this.profilePath = profilePath;
    }

    public Integer getCastId() {
        return castId;
    }

    public String getCharacter() {
        return character;
    }

    public String getCreditId() {
        return creditId;
    }

    public Integer getGender() {
        return gender;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getOrder() {
        return order;
    }

    public String getProfilePath() {
        return profilePath;
    }
}
