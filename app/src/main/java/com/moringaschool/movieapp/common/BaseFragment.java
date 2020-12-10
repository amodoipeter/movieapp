package com.moringaschool.movieapp.common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public abstract class BaseFragment<DB extends ViewDataBinding, VM extends ViewModel> extends Fragment {
    DB dataBinding;
    VM viewModel;

    @LayoutRes
    public abstract int getLayoutResource();

    public abstract Class<VM> getViewModel();

    public abstract void onCreate(@Nullable Bundle savedInstanceState, VM viewModel);

    public abstract void onCreateView(DB dataBinding);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        viewModel = viewModelProvider.get(getViewModel());

        onCreate(savedInstanceState, viewModel);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutResource(), container, false);
        onCreateView(dataBinding);
        return dataBinding.getRootandroid();
    }
}
