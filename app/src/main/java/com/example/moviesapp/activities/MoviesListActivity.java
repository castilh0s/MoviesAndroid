package com.example.moviesapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import com.example.moviesapp.R;
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

        TheMovieDBService apiService = TheMovieDB.getRetrofit().create(TheMovieDBService.class);

        Call<MoviesList> call = apiService.listMovies();
        call.enqueue(new Callback<MoviesList>() {
            @Override
            public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
                Integer statusCode = response.code();
                List<Movie> movies = response.body().getResults();

                recyclerViewMovies.setAdapter(new MoviesAdapter(movies, R.layout.adapter_movie, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<MoviesList> call, Throwable t) {
                Log.e(TAG, t.toString());

            }
        });

        final Intent movieIntent = new Intent(
                getApplicationContext(),
                MovieActivity.class
        );


//        buttonIronMan.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Movie ironMan = new Movie(
//                                R.mipmap.iron_man_scene_foreground,
//                                R.mipmap.iron_man_poster_foreground,
//                                "Iron Man",
//                                "30/04/2008",
//                                "Tony Stark (Robert Downey Jr.) é um industrial bilionário, que também é um brilhante inventor. Ao ser sequestrado ele é obrigado por terroristas a construir uma arma devastadora mas, ao invés disto, constrói uma armadura de alta tecnologia que permite que fuja de seu cativeiro. A partir de então ele passa a usá-la para combater o crime, sob o alter-ego do Homem de Ferro."
//                        );
//
//                        movieIntent.putExtra("MOVIE", ironMan);
//                        startActivity(movieIntent);
//                    }
//                }
//        );
    }
}
