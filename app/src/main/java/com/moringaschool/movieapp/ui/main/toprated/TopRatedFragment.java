package com.moringaschool.movieapp.ui.main.toprated;

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

import com.moringaschool.movieapp.R;
import com.moringaschool.movieapp.common.BaseVMFragment;
import com.moringaschool.movieapp.model.movie.MovieResults;
import com.moringaschool.movieapp.ui.detail.DetailActivity;
import com.moringaschool.movieapp.ui.main.MovieAdapter;

import static com.moringaschool.movieapp.util.Constants.EXTRA_POPULAR_MOVIES;

public class TopRatedFragment extends BaseVMFragment<TopRatedViewModel> implements MovieAdapter.OnMovieClickListener {
    private RecyclerView topRatedRecyclerView;
    private ProgressBar topRatedProgressBar;
    MovieAdapter adapter;

    @Override
    public Class<TopRatedViewModel> getViewModel() {
        return TopRatedViewModel.class;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState, TopRatedViewModel viewModel) {
        adapter = new MovieAdapter(new MovieAdapter.MovieDiff(), this);
        topRatedRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        viewModel.getTopRatedMovies().observe(this, movieResults -> {
            adapter.submitList(movieResults);
            topRatedRecyclerView.setAdapter(adapter);
            topRatedRecyclerView.setVisibility(View.VISIBLE);
            topRatedProgressBar.setVisibility(View.GONE);
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_rated_fragment, container, false);
        topRatedRecyclerView = view.findViewById(R.id.toprated_recyclerview);
        topRatedProgressBar = view.findViewById(R.id.toprated_progressbar);
        return view;
    }

    @Override
    public void onMovieClick(MovieResults movieResults) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(EXTRA_POPULAR_MOVIES, movieResults);
        startActivity(intent);
    }
}