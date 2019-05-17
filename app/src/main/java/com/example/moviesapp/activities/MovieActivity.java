package com.example.moviesapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviesapp.R;
import com.example.moviesapp.models.Movie;
//import com.example.moviesapp.repositories.Movie;

public class MovieActivity extends AppCompatActivity {

    TextView textViewTitle;
    TextView textViewDate;
    TextView textViewSinopsis;
    ImageView imageViewPoster;
    ImageView imageViewScene;
    Button buttonWatch;

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
//
//        imageViewPoster.setImageResource(movie.getPoster());
//        imageViewScene.setImageResource(movie.getScene());

//        buttonWatch.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent watchIntent = new Intent(getApplicationContext(), WatchActivity.class);
//
//                        watchIntent.putExtra("MOVIE", movie);
//                        startActivity(watchIntent);
//                    }
//                }
//        );
    }
}
