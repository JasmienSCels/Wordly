package com.example.jasmiensofiecels.wordly.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.jasmiensofiecels.wordly.service.model.OxfordEntry.Example;
import com.example.jasmiensofiecels.wordly.service.repository.DictionaryRepository;

/**
 * The purpose of this class is to represent the viewModel that gets observed by the view
 * and calls the model (DictionaryRepository) to get data.
 *
 * Created by Jasmien Cels on 04/04/2018.
 */

public class DictionaryViewModel extends ViewModel {

    public DictionaryRepository repository;

    private static MutableLiveData<Example> resultObservable = new MutableLiveData<Example>() {} ;


    public DictionaryViewModel(DictionaryRepository repository) {
        this.repository = repository;

        MutableLiveData<String> word = new MutableLiveData<>();
        word.setValue("first");
        resultObservable = this.repository.getWordOfTheDay("en", word);
    }

    public void onWordRefresh(MutableLiveData<String> word) {
        resultObservable = repository.getWordOfTheDay("en", word);
    }

    public LiveData<Example> getResultObservable() {
        return resultObservable;
    }

}
