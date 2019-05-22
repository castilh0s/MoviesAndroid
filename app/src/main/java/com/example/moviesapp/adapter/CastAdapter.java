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
import com.example.moviesapp.models.Cast;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {
    private List<Cast> castList;
    private int rowLayout;
    private Context context;

    public CastAdapter(List<Cast> castList, int rowLayout, Context context) {
        this.castList = castList;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(
                R.layout.adapter_credits,
                viewGroup,
                false
        );

        return new CastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder castViewHolder, int i) {
        Cast cast = castList.get(i);

        System.out.println("Profile Path: " + cast.getProfilePath());

        if (cast.getProfilePath() != null) {
            System.out.println("Diferente de null");
            Picasso.get().load("https://image.tmdb.org/t/p/w300_and_h300_bestv2/" + cast.getProfilePath()).into(castViewHolder.personImage);
        } else {
            System.out.println("Igual a null");
            Picasso.get().load("http://cliquecities.com/assets/no-image-e3699ae23f866f6cbdf8ba2443ee5c4e.jpg").into(castViewHolder.personImage);
        }

        castViewHolder.name.setText(cast.getName());
    }

    @Override
    public int getItemCount() {
        return castList.size();
    }

    public static class CastViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView personImage;

        public CastViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameTextView);
            personImage = itemView.findViewById(R.id.personImageView);
        }
    }
}
