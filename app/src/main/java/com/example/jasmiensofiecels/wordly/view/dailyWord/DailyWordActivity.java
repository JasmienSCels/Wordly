package com.example.jasmiensofiecels.wordly.view.dailyWord;

import android.os.Bundle;

import com.example.jasmiensofiecels.wordly.R;
import com.example.jasmiensofiecels.wordly.presenter.base.dailyWord.DailyWordView;
import com.example.jasmiensofiecels.wordly.view.Base.BaseActivity;

import javax.inject.Inject;

/*
 * The purpose of this activity class is to display the word of the day to the user.
 */

public class DailyWordActivity extends BaseActivity implements DailyWordView {

    @Inject
    DailyWordPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_word);

        presenter.attachView(this);
    }

    @Override
    public void renderWordOfTheDay() {

    }

    @Override
    public void refreshWordOfTheDay() {

    }
}
