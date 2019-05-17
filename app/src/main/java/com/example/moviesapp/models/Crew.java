package com.example.moviesapp.models;

import com.google.gson.annotations.SerializedName;

public class Crew {
    @SerializedName("credit_id")
    private String creditId;

    @SerializedName("department")
    private String department;

    @SerializedName("gender")
    private Integer gender;

    @SerializedName("id")
    private Integer id;

    @SerializedName("job")
    private String job;

    @SerializedName("name")
    private String name;

    @SerializedName("profile_path")
    private String profilePath;

    public Crew(String creditId, String department, Integer gender, Integer id, String job, String name, String profilePath) {
        this.creditId = creditId;
        this.department = department;
        this.gender = gender;
        this.id = id;
        this.job = job;
        this.name = name;
        this.profilePath = profilePath;
    }

    public String getCreditId() {
        return creditId;
    }

    public String getDepartment() {
        return department;
    }

    public Integer getGender() {
        return gender;
    }

    public Integer getId() {
        return id;
    }

    public String getJob() {
        return job;
    }

    public String getName() {
        return name;
    }

    public String getProfilePath() {
        return profilePath;
    }
}
