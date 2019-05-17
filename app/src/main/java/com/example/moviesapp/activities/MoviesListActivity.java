package com.example.moviesapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.moviesapp.R;
import com.example.moviesapp.RecyclerItemClickListener;
import com.example.moviesapp.adapter.MoviesAdapter;
import com.example.moviesapp.models.Movie;
import com.example.moviesapp.models.MoviesList;
import com.example.moviesapp.services.TheMovieDB;
import com.example.moviesapp.services.TheMovieDBService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesListActivity extends AppCompatActivity {
    private static final String TAG = MoviesListActivity.class.getSimpleName();
    private RecyclerView recyclerViewMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);

        recyclerViewMovies = findViewById(R.id.recyclerViewMovies);
        recyclerViewMovies.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        final Intent movieIntent = new Intent(
                getApplicationContext(),
                MovieActivity.class
        );

        TheMovieDBService apiService = TheMovieDB.getRetrofit().create(TheMovieDBService.class);

        Call<MoviesList> call = apiService.listMovies();
        call.enqueue(new Callback<MoviesList>() {
            @Override
            public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
                Integer statusCode = response.code();
                final List<Movie> movies = response.body().getResults();

                recyclerViewMovies.setAdapter(new MoviesAdapter(movies, R.layout.adapter_movie, getApplicationContext()));
                recyclerViewMovies.addOnItemTouchListener(
                        new RecyclerItemClickListener(
                                getApplicationContext(),
                                recyclerViewMovies,
                                new RecyclerItemClickListener.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(View view, int position) {
                                        Movie movie = movies.get(position);

                                        movieIntent.putExtra("MOVIE", movie);
                                        startActivity(movieIntent);
                                    }

                                    @Override
                                    public void onLongItemClick(View view, int position) {
                                        Movie movie = movies.get(position);

                                        movieIntent.putExtra("MOVIE", movie);
                                        startActivity(movieIntent);
                                    }

                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                        Movie movie = movies.get(position);

                                        movieIntent.putExtra("MOVIE", movie);
                                        startActivity(movieIntent);
                                    }
                                }
                        )
                );
            }

            @Override
            public void onFailure(Call<MoviesList> call, Throwable t) {
                Log.e(TAG, t.toString());

            }
        });
    }
}
