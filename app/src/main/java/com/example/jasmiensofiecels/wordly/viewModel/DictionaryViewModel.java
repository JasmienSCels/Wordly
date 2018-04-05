package com.example.jasmiensofiecels.wordly.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.jasmiensofiecels.wordly.service.model.OxfordEntry.Example;
import com.example.jasmiensofiecels.wordly.service.repository.DictionaryRepository;

/**
 * The purpose of this class is...
 *
 * Created by Jasmien Cels on 04/04/2018.
 */

public class DictionaryViewModel extends ViewModel {


    private static MutableLiveData<Example> resultObservable = new MutableLiveData<Example>() {} ;

    private DictionaryRepository service = new DictionaryRepository();

    public DictionaryViewModel() {
            MutableLiveData<String> word = new MutableLiveData<>();
            word.setValue("first");
            resultObservable = service.getWordOfTheDay("en", word);
    }

    public void onWordRefresh(MutableLiveData<String> word) {
        resultObservable = service.getWordOfTheDay("en", word);
    }

    public LiveData<Example> getResultObservable() {
        return resultObservable;
    }

}
