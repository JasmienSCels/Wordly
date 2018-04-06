package com.example.jasmiensofiecels.wordly.viewModel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

/**
 * The purpose of this class is to represent the factory
 * that will get injected by Dagger into its corresponding view activity in order to instantiate
 * the appropriate ViewModel.
 *
 * Created by Jasmien Cels on 06/04/2018.
 */

public class DictionaryViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if(modelClass.isAssignableFrom(DictionaryViewModel.class)) {
            return (T) new DictionaryViewModel();
        }

        throw new IllegalArgumentException("Illegal Argument Exception: Unknown Model View");
    }
}