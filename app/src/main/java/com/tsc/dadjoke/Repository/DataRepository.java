package com.tsc.dadjoke.Repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tsc.dadjoke.mvvm.model.Joke;
import com.tsc.dadjoke.network.ApiRequest;
import com.tsc.dadjoke.network.RetrofitRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {

    private final ApiRequest apiRequest;

    public DataRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<Joke> getJoke() {
        final MutableLiveData<Joke> data = new MutableLiveData<>();
        apiRequest.getJokes()
                .enqueue(new Callback<Joke>() {
                    @Override
                    public void onResponse(Call<Joke> call, Response<Joke> response) {
                        assert response.body() != null;
                        data.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<Joke> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }

}
