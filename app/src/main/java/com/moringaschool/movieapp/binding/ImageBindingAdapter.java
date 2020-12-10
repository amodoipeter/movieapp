package com.moringaschool.movieapp.binding;

import android.widget.ImageView;


import com.bumptech.glide.Glide;
import androidx.databinding.BindingAdapter;


import static com.moringaschool.movieapp.util.Constants.IMAGE_BASE_URL;
import static com.moringaschool.movieapp.util.Constants.IMAGE_W342;

public class ImageBindingAdapter {
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        if (!url.isEmpty()) {
            Glide.with(imageView.getContext())
                    .load(IMAGE_BASE_URL + IMAGE_W342 + url)
                    .into(imageView);
        }
    }
}
