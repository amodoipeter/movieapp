package com.moringaschool.movieapp.ui.detail.overview;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.moringaschool.movieapp.common.BaseRepository;
import com.moringaschool.movieapp.model.detail.MovieDetailResponse;
import com.moringaschool.movieapp.model.video.MovieVideoResponse;
import com.moringaschool.movieapp.model.video.MovieVideoResults;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author moringa
 */
public class OverviewRepository extends BaseRepository {

    public MutableLiveData<MovieDetailResponse> getDetails(int movieId) {
        MutableLiveData<MovieDetailResponse> movieDetailLive = new MutableLiveData<>();
        apiService.getMovieDetail(movieId).enqueue(new Callback<MovieDetailResponse>() {
            @Override
            public void onResponse(Call<MovieDetailResponse> call, Response<MovieDetailResponse> response) {
                movieDetailLive.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MovieDetailResponse> call, Throwable t) {
                Log.e("getDetails", t.getMessage());
            }
        });
        return movieDetailLive;
    }

    public MutableLiveData<List<MovieVideoResults>> getMovieVideos(int movieId) {
        MutableLiveData<List<MovieVideoResults>> movieVideoLive = new MutableLiveData<>();
        apiService.getMovieVideos(movieId).enqueue(new Callback<MovieVideoResponse>() {
            @Override
            public void onResponse(Call<MovieVideoResponse> call, Response<MovieVideoResponse> response) {
                movieVideoLive.setValue(response.body().getResults());
            }

            @Override
            public void onFailure(Call<MovieVideoResponse> call, Throwable t) {
                Log.e("getMovieVideos", t.getMessage());
            }
        });
        return movieVideoLive;
    }
}
