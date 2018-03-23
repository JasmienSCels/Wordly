package com.example.jasmiensofiecels.wordly.view.dailyWord;

import com.example.jasmiensofiecels.wordly.presenter.base.base.BaseService;
import com.example.jasmiensofiecels.wordly.presenter.base.dailyWord.DailyWordService;
import com.example.jasmiensofiecels.wordly.presenter.base.dailyWord.DailyWordView;
import com.example.jasmiensofiecels.wordly.view.Base.BasePresenter;

/**
 * The purpose of this class is to
 * Created by Jasmien Cels on 23/03/2018.
 */

public class DailyWordPresenter<V extends DailyWordView> extends BasePresenter<V> implements BaseService.BasePresenter<V>, DailyWordService.ResponseListener {

    private DailyWordView view;
    private DailyWordService service;

    public DailyWordPresenter(DailyWordView view, DailyWordService service) {
        this.view = view;
        this.service = service;
    }



    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailure() {

    }
}
