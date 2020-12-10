package com.moringaschool.movieapp.ui.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.movieapp.databinding.MovieItemBinding;
import com.moringaschool.movieapp.model.movie.MovieResults;


/**
 * @author moringa
 */
public class MovieViewHolder extends RecyclerView.ViewHolder {

    private final MovieItemBinding binding;

    public MovieViewHolder(MovieItemBinding binding, MovieAdapter.OnMovieClickListener onMovieClickListener) {
        super(binding.getRoot());
        this.binding = binding;
        binding.getRoot().setOnClickListener(v -> onMovieClickListener.onMovieClick(binding.getMovie()));
    }

    public void bind(MovieResults movieResults) {
        binding.setMovie(movieResults);
        binding.executePendingBindings();
    }

    public static com.moringaschool.movieapp.ui.main.MovieViewHolder create(LayoutInflater inflater, ViewGroup parent, MovieAdapter.OnMovieClickListener onMovieClickListener) {
        MovieItemBinding movieItemBinding = MovieItemBinding.inflate(inflater, parent, false);
        return new com.moringaschool.movieapp.ui.main.MovieViewHolder(movieItemBinding, onMovieClickListener);
    }
}
