package com.example.jasmiensofiecels.wordly.view.dailyWord;

import com.example.jasmiensofiecels.wordly.presenter.base.dailyWord.DailyWordService;
import com.example.jasmiensofiecels.wordly.presenter.base.dailyWord.DailyWordView;

import dagger.Module;
import dagger.Provides;

/**
 * The purpose of this class is be represent the module
 * Created by Jasmien Cels on 23/03/2018.
 */

@Module
public class DailyWordModule {

    @Provides
    public DailyWordView provideDailyWordView(DailyWordActivity activity) {
        return activity;
    }

    @Provides
    public DailyWordPresenter provideDailyWordPresenter(DailyWordView view) {
        return new DailyWordPresenter(view);
    }

//    @Provides
//    public DailyWordService provideDailyWordService() {
//        return new OxfordDictionaryService();
//    }


}
