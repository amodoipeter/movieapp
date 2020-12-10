package com.moringaschool.movieapp.ui.detail.overview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.moringaschool.movieapp.R;
import com.moringaschool.movieapp.common.BaseFragment;
import com.moringaschool.movieapp.databinding.OverviewMovieFragmentBinding;
import com.moringaschool.movieapp.model.movie.MovieResults;

import static com.moringaschool.movieapp.util.Constants.MOVIE_KEY;
import static com.moringaschool.movieapp.util.Constants.YOUTUBE_WATCH_URL;

/**
 * @author moringa
 */
public class OverviewMovieFragment extends BaseFragment<OverviewMovieFragmentBinding, OverviewMovieViewModel> {

    private OverviewMovieViewModel viewModel;
    private OverviewMovieFragmentBinding dataBinding;

    public static com.moringaschool.movieapp.ui.detail.overview.OverviewMovieFragment newInstance(MovieResults movie) {
        Bundle args = new Bundle();
        args.putParcelable(MOVIE_KEY, movie);
        com.moringaschool.movieapp.ui.detail.overview.OverviewMovieFragment fragment = new com.moringaschool.movieapp.ui.detail.overview.OverviewMovieFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResource() {
        return R.layout.overview_movie_fragment;
    }

    @Override
    public Class<OverviewMovieViewModel> getViewModel() {
        return OverviewMovieViewModel.class;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, OverviewMovieViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void onCreateView(OverviewMovieFragmentBinding dataBinding) {
        this.dataBinding = dataBinding;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MovieResults movieResults = getArguments().getParcelable(MOVIE_KEY);
        int movieId = movieResults.getMovieId();
        viewModel.getDetails(movieId).observe(this, movieDetailResponse -> dataBinding.setDetails(movieDetailResponse));

        dataBinding.detailMovieVideosProgress.setVisibility(View.VISIBLE);
        dataBinding.movieVideosRecyclerview.setVisibility(View.GONE);

        viewModel.getVideos(movieId).observe(this, movieVideoResults -> {
            VideoAdapter videoAdapter = new VideoAdapter(new VideoAdapter.VideoDiff(), video -> {
                Intent intent = new Intent();
                intent.setData(Uri.parse(YOUTUBE_WATCH_URL + video.getKey()));
                startActivity(intent);
            });

            dataBinding.movieVideosRecyclerview.setAdapter(videoAdapter);
            videoAdapter.submitList(movieVideoResults);

            dataBinding.detailMovieVideosProgress.setVisibility(View.GONE);
            dataBinding.movieVideosRecyclerview.setVisibility(View.VISIBLE);
        });
    }

}