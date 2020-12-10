package com.moringaschool.movieapp.ui.detail.overview;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.movieapp.databinding.ItemVideoBinding;
import com.moringaschool.movieapp.model.video.MovieVideoResults;

/**
 * @author moringa
 */
public class VideoViewHolder extends RecyclerView.ViewHolder {
    private final ItemVideoBinding binding;

    public VideoViewHolder(ItemVideoBinding binding, VideoAdapter.OnVideoClickListener onVideoClickListener) {
        super(binding.getRoot());
        this.binding = binding;
        binding.getRoot().setOnClickListener(v -> onVideoClickListener.onVideoClick(binding.getVideo()));
    }

    public void bind(MovieVideoResults movieVideoResults) {
        binding.setVideo(movieVideoResults);
        binding.executePendingBindings();
    }

    public static com.moringaschool.movieapp.ui.detail.overview.VideoViewHolder create(LayoutInflater inflater, ViewGroup parent, VideoAdapter.OnVideoClickListener onVideoClickListener) {
        ItemVideoBinding itemVideoBinding = ItemVideoBinding.inflate(inflater, parent, false);
        return new com.moringaschool.movieapp.ui.detail.overview.VideoViewHolder(itemVideoBinding, onVideoClickListener);

    }
}
