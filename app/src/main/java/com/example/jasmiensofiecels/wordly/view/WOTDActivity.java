package com.example.jasmiensofiecels.wordly.view;

import android.os.Bundle;

import com.example.jasmiensofiecels.wordly.R;
import com.example.jasmiensofiecels.wordly.presenter.base.dailyWord.DailyWordView;
import com.example.jasmiensofiecels.wordly.view.Base.BaseActivity;
import com.example.jasmiensofiecels.wordly.view.dailyWord.DailyWordPresenter;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/*
 * The purpose of this view class is to display the word of the day.
 */

public class WOTDActivity extends BaseActivity implements DailyWordView{

    @Inject
    DailyWordPresenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void renderWordOfTheDay() {

    }

    @Override
    public void refreshWordOfTheDay() {
        presenter.getWord();
    }
}
