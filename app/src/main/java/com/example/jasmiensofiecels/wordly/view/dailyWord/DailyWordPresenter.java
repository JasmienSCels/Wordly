package com.example.jasmiensofiecels.wordly.view.dailyWord;

import com.example.jasmiensofiecels.wordly.presenter.base.base.BaseService;
import com.example.jasmiensofiecels.wordly.presenter.base.dailyWord.DailyWordService;
import com.example.jasmiensofiecels.wordly.presenter.base.dailyWord.DailyWordView;
import com.example.jasmiensofiecels.wordly.view.base.BasePresenter;

/**
 * The purpose of this class is to represent the delegation between the view and its corresponding service. The service will retrieve
 * a random new word from the dictionary API and send the results back to the view.
 *
 * Created by Jasmien Cels on 23/03/2018.
 */

public class DailyWordPresenter<V extends DailyWordView> extends BasePresenter<V> implements BaseService.BasePresenter<V>, DailyWordService.ResponseListener {

    private DailyWordView view;
   // private OxfordDictionaryService service;

    public DailyWordPresenter(DailyWordView view) {
        this.view = view;
        //this.service = service;
    }

  //  public void getWord() {
//        service.getWordOfTheDay(this);
//    }

    @Override
    public void onSuccess() {
        //TODO: should accept the word object or string as param.
        view.renderWordOfTheDay();
    }

    @Override
    public void onFailure() {

    }
}
