package com.example.moviesapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviesapp.R;
import com.example.moviesapp.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {
    private List<Movie> movies;
    private int rowLayout;
    private Context context;

    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(
                R.layout.adapter_movie,
                viewGroup,
                false
        );

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        Movie movie = movies.get(i);

        Picasso.get().load("https://image.tmdb.org/t/p/w600_and_h900_bestv2/" + movie.getPosterPath()).into(movieViewHolder.poster);
        movieViewHolder.title.setText(movie.getTitle());
        movieViewHolder.date.setText(movie.getReleaseDate());
        movieViewHolder.sinopsis.setText(movie.getOverview());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView date;
        TextView sinopsis;
        ImageView poster;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.posterImage2);
            title = itemView.findViewById(R.id.textViewTitle);
            date = itemView.findViewById(R.id.textViewYear);
            sinopsis = itemView.findViewById(R.id.textViewSinopsis);
        }
    }
}
