package com.moringaschool.movieapp.ui.detail.overview;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.moringaschool.movieapp.model.video.MovieVideoResults;


/**
 * @author moringa
 */
public class VideoAdapter extends ListAdapter<MovieVideoResults, VideoViewHolder> {
    OnVideoClickListener onVideoClickListener;

    protected VideoAdapter(@NonNull DiffUtil.ItemCallback<MovieVideoResults> diffCallback, OnVideoClickListener onVideoClickListener) {
        super(diffCallback);
        this.onVideoClickListener = onVideoClickListener;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return VideoViewHolder.create(LayoutInflater.from(parent.getContext()), parent, onVideoClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    static class VideoDiff extends DiffUtil.ItemCallback<MovieVideoResults> {
        @Override
        public boolean areItemsTheSame(@NonNull MovieVideoResults oldItem, @NonNull MovieVideoResults newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull MovieVideoResults oldItem, @NonNull MovieVideoResults newItem) {
            return oldItem.getId().equals(newItem.getId());
        }
    }

    public interface OnVideoClickListener {
        void onVideoClick(MovieVideoResults video);
    }
}
