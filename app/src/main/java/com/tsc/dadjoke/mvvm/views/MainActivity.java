package com.tsc.dadjoke.mvvm.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.material.snackbar.Snackbar;
import com.tsc.dadjoke.R;
import com.tsc.dadjoke.adapters.JokeAdapter;
import com.tsc.dadjoke.mvvm.model.Joke;
import com.tsc.dadjoke.mvvm.viewmodel.JokeViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private final ArrayList<Joke> jokeArrayList = new ArrayList<>();
    private JokeViewModel jokeViewModel;
    private JokeAdapter jokeAdapter;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
        setupViewModel();
        setupObservable(view);
    }

    private void setupView() {
        view = findViewById(android.R.id.content).getRootView();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        jokeAdapter = new JokeAdapter(jokeArrayList);
        recyclerView.setAdapter(jokeAdapter);
    }

    private void setupViewModel() {
        jokeViewModel = new ViewModelProvider(this).get(JokeViewModel.class);
    }

    @SuppressLint("NotifyDataSetChanged")
    private void setupObservable(View view) {
        jokeViewModel.getJokeLiveData().observe(this, joke -> {
            if (joke != null) {
                jokeArrayList.clear();
                jokeArrayList.add(joke);
                jokeAdapter.notifyDataSetChanged();
            }
            else {
                Snackbar.make(view, "ERROR TO LOAD DATA. TRY AGAIN LATER.", Snackbar.LENGTH_LONG).show();
            }
            progressBar.setVisibility(View.GONE);
        });
    }
}