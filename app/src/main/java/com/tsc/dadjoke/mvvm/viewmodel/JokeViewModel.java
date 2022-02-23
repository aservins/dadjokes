package com.tsc.dadjoke.mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.tsc.dadjoke.Repository.DataRepository;
import com.tsc.dadjoke.mvvm.model.Joke;

public class JokeViewModel extends AndroidViewModel {

    private DataRepository jokeRepository;
    private LiveData<Joke> jokeLiveData;

    public JokeViewModel(@NonNull Application application) {
        super(application);
        jokeRepository = new DataRepository();
        jokeLiveData = jokeRepository.getJoke();
    }

    public LiveData<Joke> getJokeLiveData() {
        return jokeLiveData;
    }

}
