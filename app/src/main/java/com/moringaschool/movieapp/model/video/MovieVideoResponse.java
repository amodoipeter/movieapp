package com.moringaschool.movieapp.model.video;

import com.google.gson.annotations.SerializedName;
import com.moringaschool.movieapp.model.video.MovieVideoResults;

import java.util.List;

public class MovieVideoResponse {
    @SerializedName("id")
    int id;
    @SerializedName("results")
    List<MovieVideoResults> results;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MovieVideoResults> getResults() {
        return results;
    }

    public void setResults(List<MovieVideoResults> results) {
        this.results = results;
    }
}
