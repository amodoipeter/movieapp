package com.moringaschool.movieapp.ui.detail.review;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.moringaschool.movieapp.R;
import com.moringaschool.movieapp.model.movie.MovieResults;

import java.util.List;

import static com.moringaschool.movieapp.util.Constants.MOVIE_KEY;


public class ReviewMovieFragment extends BaseVMFragment<ReviewMovieViewModel> {
    private RecyclerView reviewRecylerView;
    private ProgressBar reviewProgress;

    public static com.moringaschool.movieapp.ui.detail.review.ReviewMovieFragment newInstance(MovieResults movie) {
        Bundle args = new Bundle();
        args.putParcelable(MOVIE_KEY, movie);
        com.moringaschool.movieapp.ui.detail.review.ReviewMovieFragment fragment = new com.moringaschool.movieapp.ui.detail.review.ReviewMovieFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Class<ReviewMovieViewModel> getViewModel() {
        return ReviewMovieViewModel.class;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.review_movie_fragment, container, false);
        reviewRecylerView = view.findViewById(R.id.review_recyclerview);
        reviewProgress = view.findViewById(R.id.review_progress);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState, ReviewMovieViewModel viewModel) {
        MovieResults movieResults = getArguments().getParcelable(MOVIE_KEY);
        int movieId = movieResults.getMovieId();
        ReviewAdapter adapter = new ReviewAdapter(new ReviewAdapter.ReviewDiff());
        reviewRecylerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        viewModel.getReviews(movieId).observe(this, new Observer<List<MovieReviewResult>>() {
            @Override
            public void onChanged(List<MovieReviewResult> movieReviewResults) {
                reviewRecylerView.setAdapter(adapter);
                adapter.submitList(movieReviewResults);

                reviewProgress.setVisibility(View.GONE);
                reviewRecylerView.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}