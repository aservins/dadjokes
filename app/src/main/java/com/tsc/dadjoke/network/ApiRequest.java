package com.tsc.dadjoke.network;

import com.tsc.dadjoke.mvvm.model.Joke;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiRequest {

    @Headers("Accept: application/json")
    @GET("/")
    Call<Joke> getJokes();

}
