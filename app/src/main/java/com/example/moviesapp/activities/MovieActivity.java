package com.example.moviesapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.moviesapp.R;
import com.example.moviesapp.repositories.Movie;

public class MovieActivity extends AppCompatActivity {

    TextView textViewTitle;
    TextView textViewDate;
    TextView textViewSinopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        addListenerOnWatchButton();

        textViewTitle = findViewById(R.id.movieTitleText);
        textViewDate = findViewById(R.id.dateText);
        textViewSinopsis = findViewById(R.id.sinopsisText);

        Bundle data = getIntent().getExtras();
        Movie movie = (Movie) data.getSerializable("MOVIE");

        textViewTitle.setText(movie.getTitle());
        textViewDate.setText(movie.getDate());
        textViewSinopsis.setText(movie.getSinopsis());
    }

    public void addListenerOnWatchButton() {
        final Context context = this;
        Button watchButton = findViewById(R.id.watchButton);

        watchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WatchActivity.class);
                startActivity(intent);
            }
        });
    }
}
