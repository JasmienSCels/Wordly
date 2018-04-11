package com.example.jasmiensofiecels.wordly.view.dailyWord;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jasmiensofiecels.wordly.R;
import com.example.jasmiensofiecels.wordly.service.model.OxfordEntry.Example;
import com.example.jasmiensofiecels.wordly.view.base.BaseActivity;
import com.example.jasmiensofiecels.wordly.viewModel.DictionaryViewModel;
import com.example.jasmiensofiecels.wordly.viewModel.DictionaryViewModelFactory;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/*
 * The purpose of this activity class is to display the word of the day to the user.
 * User input is delegated to the viewModel to retrieve a word definition.
 *
 * Created by Jasmien Cels on 23/03/2018.
 */

public class DailyWordActivity extends BaseActivity implements DailyWordView {

    @Inject
    DictionaryViewModelFactory factory;

    //UI Widgets
    Button refreshBtn;
    EditText searchTv;
    TextView wordTitle;

    private DictionaryViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_word);

        //Create the view model, which is injected via the factory.
        viewModel = ViewModelProviders.of(this, factory).get(DictionaryViewModel.class);
        observeViewModel(viewModel);


        searchTv = findViewById(R.id.search_word_et);
        wordTitle = findViewById(R.id.defined_word_tv);


        refreshBtn = findViewById(R.id.search_btn);
        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MutableLiveData<String> wordChange = new MutableLiveData<>();

                //TODO: Check against null inputs
                wordChange.setValue(searchTv.getText().toString());
                viewModel.onWordRefresh(wordChange);

                //TODO: why do I need to observe again??? Scope?
                observeViewModel(viewModel);
            }
        });
    }

    private void observeViewModel(final DictionaryViewModel viewModel) {
        viewModel.getResultObservable().observe(this, new Observer<Example>() {
            @Override
            public void onChanged(@Nullable Example response) {
                renderWordOfTheDay(response);
                Log.d("Observable", response.getResults().get(0).getWord());
            }
        });
    }

    @Override
    public void renderWordOfTheDay(Example response) {
        wordTitle.setText(response.getResults().get(0).getId());
    }

    @Override
    public void refreshWordOfTheDay() {

    }
}
