package com.moringaschool.movieapp.ui.detail.review;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import com.moringaschool.movieapp.model.reviews.MovieReviewResult;

import java.util.List;

/**
 * @author moringa
 */
public class ReviewMovieViewModel extends ViewModel {
    ReviewRepository repository = new ReviewRepository();

    public LiveData<List<MovieReviewResult>> getReviews(int movieId) {
        return repository.getReviews(movieId);
    }
}