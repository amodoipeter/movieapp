package com.moringaschool.movieapp.ui.main.popular;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class PopularMoviesViewModel extends ViewModel {
    MainRepository repository;

    public PopularMoviesViewModel() {
        this.repository = new MainRepository();
    }

    public LiveData<List<MovieResults>> getPopularMovies() {
        return repository.getPopularMovies();
    }
}