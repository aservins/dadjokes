package com.tsc.dadjoke.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tsc.dadjoke.R;
import com.tsc.dadjoke.mvvm.model.Joke;

import java.util.ArrayList;

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.ViewHolder> {

    ArrayList<Joke> jokes;

    public JokeAdapter(ArrayList<Joke> jokes) {
        this.jokes = jokes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Joke joke = jokes.get(position);
        holder.jokeTextView.setText(joke.getJoke());
    }

    @Override
    public int getItemCount() {
        return jokes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView jokeTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            jokeTextView = itemView.findViewById(R.id.jokeTextView);
        }
    }
}
