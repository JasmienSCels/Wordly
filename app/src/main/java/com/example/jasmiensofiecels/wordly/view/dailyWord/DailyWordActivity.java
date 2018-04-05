package com.example.jasmiensofiecels.wordly.view.dailyWord;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.jasmiensofiecels.wordly.R;
import com.example.jasmiensofiecels.wordly.presenter.base.dailyWord.DailyWordView;
import com.example.jasmiensofiecels.wordly.service.model.OxfordEntry.Example;
import com.example.jasmiensofiecels.wordly.view.base.BaseActivity;
import com.example.jasmiensofiecels.wordly.viewModel.DictionaryViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/*
 * The purpose of this activity class is to display the word of the day to the user.
 */

public class DailyWordActivity extends BaseActivity implements DailyWordView {

    @Inject
    DailyWordPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_word);


        DictionaryViewModel viewModel = ViewModelProviders.of(this).get(DictionaryViewModel.class);
        observeViewModel(viewModel);
    }

    private void observeViewModel(DictionaryViewModel viewModel) {
        viewModel.getResultObservable().observe(this, new Observer<Example>() {
            @Override
            public void onChanged(@Nullable Example response) {
                //TODO: update UI
                Log.d("Observable", response.getResults().get(0).getWord());
            }
        });
    }

    @Override
    public void renderWordOfTheDay() {

    }

    @Override
    public void refreshWordOfTheDay() {

    }
}
