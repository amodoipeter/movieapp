package com.moringaschool.movieapp.ui.main.favorites;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.movieapp.common.BaseVMFragment;
import com.moringaschool.movieapp.ui.detail.DetailViewModel;
import com.moringaschool.movieapp.util.Constants;

import static android.app.PendingIntent.getActivity;
import static androidx.core.content.ContextCompat.startActivity;

/**
 * @author moringa
 */

public class FavoritesFragment extends BaseVMFragment<DetailViewModel> implements MovieAdapter.OnMovieClickListener {
    MovieAdapter adapter;
    private RecyclerView favoritesRecyclerView;
    private ProgressBar favoritesProgressBar;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.favorites_fragment, container, false);
        favoritesRecyclerView = view.findViewById(R.id.favorites_recyclerview);
        favoritesProgressBar = view.findViewById(R.id.favorites_progressbar);
        return view;
    }

    @Override
    public Class<DetailViewModel> getViewModel() {
        return DetailViewModel.class;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState, DetailViewModel viewModel) {
        adapter = new MovieAdapter(new MovieAdapter.MovieDiff(), this);
        favoritesRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        viewModel.getAllMovies().observe(this, movieResults -> {
            adapter.submitList(movieResults);
            favoritesRecyclerView.setAdapter(adapter);
            favoritesRecyclerView.setVisibility(View.VISIBLE);
            favoritesProgressBar.setVisibility(View.GONE);
        });
    }

    @Override
    public void onMovieClick(MovieResults movieResults) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(Constants.EXTRA_POPULAR_MOVIES, movieResults);
        startActivity(intent);
    }
}