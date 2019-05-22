package com.example.moviesapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviesapp.R;
import com.example.moviesapp.adapter.CastAdapter;
import com.example.moviesapp.adapter.CrewAdapter;
import com.example.moviesapp.models.Cast;
import com.example.moviesapp.models.Credits;
import com.example.moviesapp.models.Crew;
import com.example.moviesapp.models.Movie;
import com.example.moviesapp.services.TheMovieDB;
import com.example.moviesapp.services.TheMovieDBService;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieActivity extends AppCompatActivity {

    private static final String TAG = MovieActivity.class.getSimpleName();
    private TextView textViewTitle;
    private TextView textViewDate;
    private TextView textViewSinopsis;
    private ImageView imageViewPoster;
    private RecyclerView recyclerViewCast;
    private RecyclerView recyclerViewCrew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        textViewTitle = findViewById(R.id.movieTitleText);
        textViewDate = findViewById(R.id.dateText);
        textViewSinopsis = findViewById(R.id.sinopsisText);
        imageViewPoster = findViewById(R.id.posterImage);

        Bundle data = getIntent().getExtras();
        final Movie movie = (Movie) data.getSerializable("MOVIE");

        textViewTitle.setText(movie.getTitle());
        textViewDate.setText(movie.getReleaseDate());
        textViewSinopsis.setText(movie.getOverview());
        Picasso.get().load("https://image.tmdb.org/t/p/w600_and_h900_bestv2/" + movie.getPosterPath()).into(imageViewPoster);

        LinearLayoutManager layoutManagerCast = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManagerCrew = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerViewCast = findViewById(R.id.castRecyclerView);
        recyclerViewCast.setLayoutManager(layoutManagerCast);

        recyclerViewCrew = findViewById(R.id.crewRecyclerView);
        recyclerViewCrew.setLayoutManager(layoutManagerCrew);

        TheMovieDBService apiService = TheMovieDB.getRetrofit().create(TheMovieDBService.class);
        Call <Credits> call = apiService.getCredits(movie.getId().toString());
        call.enqueue(new Callback<Credits>() {
            @Override
            public void onResponse(Call<Credits> call, Response<Credits> response) {
                Integer statusCode = response.code();
                final Credits credits = response.body();
                final List<Cast> castList = credits.getCast();
                final List<Crew> crewList = credits.getCrew();

                recyclerViewCast.setAdapter(new CastAdapter(castList, R.layout.adapter_credits, getApplicationContext()));
                recyclerViewCrew.setAdapter(new CrewAdapter(crewList, R.layout.adapter_credits, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<Credits> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
}
