package com.example.moviesapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviesapp.R;
import com.example.moviesapp.models.Movie;
import com.squareup.picasso.Picasso;

public class MovieActivity extends AppCompatActivity {

    TextView textViewTitle;
    TextView textViewDate;
    TextView textViewSinopsis;
    ImageView imageViewPoster;

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
    }
}
