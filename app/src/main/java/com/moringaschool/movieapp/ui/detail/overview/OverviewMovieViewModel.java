package com.moringaschool.movieapp.ui.detail.overview;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.moringaschool.movieapp.model.detail.MovieDetailResponse;
import com.moringaschool.movieapp.model.video.MovieVideoResults;

import java.util.List;

/**
 * @author moringa
 */
public class OverviewMovieViewModel extends ViewModel {
    OverviewRepository overviewRepository;

    public OverviewMovieViewModel() {
        this.overviewRepository = new OverviewRepository();
    }

    public LiveData<MovieDetailResponse> getDetails(int movieId) {
        return overviewRepository.getDetails(movieId);
    }

    public LiveData<List<MovieVideoResults>> getVideos(int movieId) {
        return overviewRepository.getMovieVideos(movieId);
    }
}