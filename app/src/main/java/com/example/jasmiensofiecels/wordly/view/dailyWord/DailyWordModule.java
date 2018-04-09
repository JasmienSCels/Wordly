package com.example.jasmiensofiecels.wordly.view.dailyWord;

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
    public DictionaryViewModelFactory provideDictionaryViewModelFactory() {
        return new DictionaryViewModelFactory();
    }

    @Provides
    public DailyWordView provideDailyWordView(DailyWordActivity activity) {
        return activity;
    }

}
