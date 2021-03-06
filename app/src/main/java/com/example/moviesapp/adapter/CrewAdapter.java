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
import com.example.moviesapp.models.Crew;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CrewAdapter extends RecyclerView.Adapter<CrewAdapter.CrewViewHolder> {
    private List<Crew> crewList;
    private int rowLayout;
    private Context context;

    public CrewAdapter(List<Crew> crewList, int rowLayout, Context context) {
        this.crewList = crewList;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public CrewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(
                R.layout.adapter_credits,
                viewGroup,
                false
        );

        return new CrewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CrewViewHolder CrewViewHolder, int i) {
        Crew crew = crewList.get(i);

        if (crew.getProfilePath() != null)
            Picasso.get().load("https://image.tmdb.org/t/p/w300_and_h300_bestv2/" + crew.getProfilePath()).into(CrewViewHolder.personImage);
        else
            Picasso.get().load("http://cliquecities.com/assets/no-image-e3699ae23f866f6cbdf8ba2443ee5c4e.jpg").into(CrewViewHolder.personImage);

        CrewViewHolder.name.setText(crew.getName());
        CrewViewHolder.role.setText(crew.getDepartment());
    }

    @Override
    public int getItemCount() {
        return crewList.size();
    }

    public static class CrewViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView role;
        ImageView personImage;

        public CrewViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameTextView);
            role = itemView.findViewById(R.id.roleTextView);
            personImage = itemView.findViewById(R.id.personImageView);
        }
    }
}
