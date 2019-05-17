package com.example.moviesapp.services;

import com.example.moviesapp.models.Credits;
import com.example.moviesapp.models.GenreList;
import com.example.moviesapp.models.MoviesList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TheMovieDBService {
    String API_KEY = "11518df004464f136f1ea9018d4db6d1";

    @GET("discover/movie?sort_by=popularity.desc&api_key=" + API_KEY)
    Call<MoviesList> listMovies();

    @GET("/search/movie?query={movie}&api_key=" + API_KEY)
    Call<MoviesList> searchMovie(@Path("movie") String movie);

    @GET("/genre/movie/list?api_key=" + API_KEY)
    Call<GenreList> getGenreList();

    @GET("/movie/{movie_id}/credits?api_key=" + API_KEY)
    Call<Credits> getCredits(@Path("movie_id") String movie_id);
}
