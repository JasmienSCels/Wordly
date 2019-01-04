package com.example.jasmiensofiecels.wordly.viewModel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.jasmiensofiecels.wordly.service.model.Room.repository.StarredWordRepository;
import com.example.jasmiensofiecels.wordly.service.repository.DictionaryRepository;

import javax.inject.Inject;

/**
 * The purpose of this class is to represent the factory
 * that will get injected by Dagger into its corresponding view activity in order to instantiate
 * the appropriate ViewModel.
 *
 * Created by Jasmien Cels on 06/04/2018.
 */

public class DictionaryViewModelFactory implements ViewModelProvider.Factory {

    private DictionaryRepository repository;
    private StarredWordRepository starredWordRepository;

    @Inject
    public DictionaryViewModelFactory(DictionaryRepository repository, StarredWordRepository starredWordRepository) {
        this.repository = repository;
        this.starredWordRepository = starredWordRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if(modelClass.isAssignableFrom(DictionaryViewModel.class)) {
            return (T) new DictionaryViewModel(repository, starredWordRepository);
        }

        throw new IllegalArgumentException("Illegal Argument Exception: Unknown Model View");
    }
}
