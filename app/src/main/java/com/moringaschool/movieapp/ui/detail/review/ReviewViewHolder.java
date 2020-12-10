package com.moringaschool.movieapp.ui.detail.review;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.movieapp.model.reviews.MovieReviewResult;


/**
 * @author moringa
 */
public class ReviewViewHolder extends RecyclerView.ViewHolder {

    private final ItemReviewBinding binding;

    public ReviewViewHolder(ItemReviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(MovieReviewResult movieReviewResult) {
        binding.setReview(movieReviewResult);
        binding.executePendingBindings();
    }

    public static com.moringaschool.movieapp.ui.detail.review.ReviewViewHolder create(LayoutInflater inflater, ViewGroup parent) {
        ItemReviewBinding itemReviewBinding = ItemReviewBinding.inflate(inflater, parent, false);
        return new com.moringaschool.movieapp.ui.detail.review.ReviewViewHolder(itemReviewBinding);
    }
}
