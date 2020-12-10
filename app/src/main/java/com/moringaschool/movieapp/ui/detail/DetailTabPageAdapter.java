package com.moringaschool.movieapp.ui.detail;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.movieapp.model.movie.MovieResults;
import com.moringaschool.movieapp.ui.detail.review.ReviewMovieFragment;


public class DetailTabPageAdapter extends FragmentPagerAdapter {
    private final MovieResults movie;
    int TOTAL_TAB = 2;

    public DetailTabPageAdapter(@NonNull FragmentManager fm, MovieResults movie) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.movie = movie;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment result;
        switch (position) {
            case 0:
            default:
                result = OverviewMovieFragment.newInstance(movie);
                break;
            case 1:
                result = ReviewMovieFragment.newInstance(movie);
                break;
        }
        return result;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String result = "";
        switch (position) {
            case 0:
            default:
                result = "Overview";
                break;
            case 1:
                result = "Review";
                break;
        }
        return result;
    }

    @Override
    public int getCount() {
        return TOTAL_TAB;
    }
}
