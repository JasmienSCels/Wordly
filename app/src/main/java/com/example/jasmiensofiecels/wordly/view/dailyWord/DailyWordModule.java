package com.example.jasmiensofiecels.wordly.view.dailyWord;

import com.example.jasmiensofiecels.wordly.service.model.Room.repository.StarredWordRepository;
import com.example.jasmiensofiecels.wordly.service.repository.DictionaryRepository;
import com.example.jasmiensofiecels.wordly.viewModel.DictionaryViewModelFactory;

import dagger.Module;
import dagger.Provides;

/**
 * The purpose of this class is be represent the module that provides the instances of the
 * respective classes/interfaces.
 *
 * Created by Jasmien Cels on 23/03/2018.
 */

@Module
public class DailyWordModule {

    @Provides
    public DictionaryRepository provideDictionaryRepository() {
        return new DictionaryRepository();
    }

    @Provides
    public DictionaryViewModelFactory provideDictionaryViewModelFactory(DictionaryRepository repository, StarredWordRepository starredWordRepository) {
        return new DictionaryViewModelFactory(repository, starredWordRepository);
    }

}
