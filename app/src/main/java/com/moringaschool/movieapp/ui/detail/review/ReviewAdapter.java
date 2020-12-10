package com.moringaschool.movieapp.ui.detail.review;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;


public class ReviewAdapter extends ListAdapter<MovieReviewResult, ReviewViewHolder> {
    protected ReviewAdapter(@NonNull DiffUtil.ItemCallback<MovieReviewResult> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ReviewViewHolder.create(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    static class ReviewDiff extends DiffUtil.ItemCallback<MovieReviewResult> {

        @Override
        public boolean areItemsTheSame(@NonNull MovieReviewResult oldItem, @NonNull MovieReviewResult newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull MovieReviewResult oldItem, @NonNull MovieReviewResult newItem) {
            return oldItem.getId().equals(newItem.getId());
        }
    }
}
