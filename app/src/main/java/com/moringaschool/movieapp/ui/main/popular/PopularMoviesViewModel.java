package com.moringaschool.movieapp.ui.main.popular;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.moringaschool.movieapp.model.movie.MovieResults;
import com.moringaschool.movieapp.ui.main.MainRepository;

import java.util.List;

/**
 * @author moringa
 */
public class PopularMoviesViewModel extends ViewModel {
    MainRepository repository;

    public PopularMoviesViewModel() {
        this.repository = new MainRepository();
    }

    public LiveData<List<MovieResults>> getPopularMovies() {
        return repository.getPopularMovies();
    }
}