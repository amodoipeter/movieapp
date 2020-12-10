package com.moringaschool.movieapp.common;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author moringa
 */
public abstract class BaseActivity<DB extends ViewDataBinding, VM extends ViewModel> extends AppCompatActivity {
    DB dataBinding;
    VM viewModel;

    @LayoutRes
    public abstract int getLayoutResource();

    public abstract Class<VM> getViewModel();

    protected abstract void onCreate(Bundle instance, VM viewModel, DB binding);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);

        dataBinding = DataBindingUtil.setContentView(this, getLayoutResource());
        viewModel = viewModelProvider.get(getViewModel());

        onCreate(savedInstanceState, viewModel, dataBinding);
    }
}
