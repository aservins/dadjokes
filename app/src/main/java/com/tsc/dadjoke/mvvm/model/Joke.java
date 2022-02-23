package com.tsc.dadjoke.mvvm.model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Joke {

    @Nullable
    @Expose
    @SerializedName("id")
    private final String id;

    @Nullable
    @Expose
    @SerializedName("joke")
    private final String joke;

    @Nullable
    @Expose
    @SerializedName("status")
    private final String status;

    public Joke(@Nullable String id, @Nullable String joke, @Nullable String status) {
        this.id = id;
        this.joke = joke;
        this.status = status;
    }

    @Nullable
    public String getId() {
        return id;
    }

    @Nullable
    public String getJoke() {
        return joke;
    }

    @Nullable
    public String getStatus() {
        return status;
    }
}
