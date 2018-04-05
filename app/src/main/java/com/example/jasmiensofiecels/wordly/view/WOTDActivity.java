package com.example.jasmiensofiecels.wordly.view;

import android.os.Bundle;

import com.example.jasmiensofiecels.wordly.R;
import com.example.jasmiensofiecels.wordly.presenter.base.dailyWord.DailyWordView;
import com.example.jasmiensofiecels.wordly.view.base.BaseActivity;

/*
 * The purpose of this view class is to display the word of the day.
 *
 * Created by Jasmien Cels on 23/03/2018.
 */

public class WOTDActivity extends BaseActivity implements DailyWordView {

//    @Inject
//    DailyWordPresenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void renderWordOfTheDay() {

    }

    @Override
    public void refreshWordOfTheDay() {
        //presenter.getWord();
    }
}
