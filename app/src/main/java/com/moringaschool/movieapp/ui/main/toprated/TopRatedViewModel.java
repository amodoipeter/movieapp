package com.moringaschool.movieapp.ui.main.toprated;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class TopRatedViewModel extends ViewModel {
    MainRepository repository;

    public TopRatedViewModel() {
        this.repository = new MainRepository();
    }

    public LiveData<List<MovieResults>> getTopRatedMovies() {
        return repository.getTopRatedMovies();
    }
}