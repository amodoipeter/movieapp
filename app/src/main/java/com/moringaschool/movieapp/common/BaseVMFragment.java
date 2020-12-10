package com.moringaschool.movieapp.common;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.moringaschool.movieapp.ui.detail.DetailViewModel;

public abstract class BaseVMFragment<VM extends ViewModel> extends Fragment {
    VM viewModel;

    public abstract Class<VM> getViewModel();

    public abstract void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState, VM viewModel);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModelProvider viewModelProvider = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                if (modelClass == DetailViewModel.class) {
                    return (T) new DetailViewModel(getActivity().getApplication());
                } else {
                    return (T) ViewModelProviders.of(BaseVMFragment.this).get(getViewModel());
                }
            }
        });
        viewModel = viewModelProvider.get(getViewModel());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        onViewCreated(view, savedInstanceState, viewModel);
    }
}
