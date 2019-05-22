package com.example.moviesapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

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
    private EditText searchMovie;
    private MoviesAdapter moviesAdapter;
    private TheMovieDBService apiService;
    private Intent movieIntent;
    private RecyclerItemClickListener recyclerItemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);

        searchMovie = findViewById(R.id.search_movie);
        recyclerViewMovies = findViewById(R.id.recyclerViewMovies);
        recyclerViewMovies.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        moviesAdapter = new MoviesAdapter(R.layout.adapter_movie, getApplicationContext());
        movieIntent = new Intent(
                getApplicationContext(),
                MovieActivity.class
        );

        loadDefaultMoviesList();
        searchMovie.addTextChangedListener(getWatcher());
    }

    private void loadDefaultMoviesList() {
        apiService = TheMovieDB.getRetrofit().create(TheMovieDBService.class);
        final Call<MoviesList> call = apiService.listMovies();
        call.enqueue(getCallbackSetMovieIntent(movieIntent));
    }

    private TextWatcher getWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String searchInput = s.toString();
                filter(searchInput);
            }
        };
    }

    private void filter(String text) {
        if (text == null || text.isEmpty()) {
            loadDefaultMoviesList();
            return;
        }

        Call<MoviesList> moviesList = apiService.searchMovie(text);
        moviesList.enqueue(new Callback<MoviesList>() {
            @Override
            public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
                List<Movie> movies = response.body().getResults();
                moviesAdapter.filterList(movies);
                clickMovieListener(movies, movieIntent);
            }

            @Override
            public void onFailure(Call<MoviesList> call, Throwable t) {

            }
        });
    }

    private Callback<MoviesList> getCallbackSetMovieIntent(final Intent movieIntent) {
        return new Callback<MoviesList>() {
            @Override
            public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
                Integer statusCode = response.code();
                final List<Movie> movies = response.body().getResults();

                recyclerViewMovies.setAdapter(moviesAdapter);
                moviesAdapter.setMovies(movies);
                clickMovieListener(movies, movieIntent);
            }

            @Override
            public void onFailure(Call<MoviesList> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        };
    }

    private void clickMovieListener(final List<Movie> movies, final Intent movieIntent) {
        recyclerItemClickListener = recyclerItemMovies(movies, movieIntent);
        recyclerViewMovies.addOnItemTouchListener(recyclerItemClickListener);
    }

    private RecyclerItemClickListener recyclerItemMovies(final List<Movie> movies, final Intent movieIntent) {
        recyclerViewMovies.removeOnItemTouchListener(recyclerItemClickListener);

        return new RecyclerItemClickListener(
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
        );
    }
}
