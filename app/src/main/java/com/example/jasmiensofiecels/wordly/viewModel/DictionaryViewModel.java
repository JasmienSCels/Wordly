package com.example.jasmiensofiecels.wordly.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.jasmiensofiecels.wordly.service.model.OxfordEntry.Example;
import com.example.jasmiensofiecels.wordly.service.repository.DictionaryRepository;

/**
 *
 * The purpose of this class is...
 *
 * Created by Jasmien Cels on 04/04/2018.
 */

public class DictionaryViewModel extends ViewModel {

    public  LiveData<Example> resultObservable = new LiveData<Example>() {} ;

    DictionaryRepository service = new DictionaryRepository();

    public DictionaryViewModel() {

        resultObservable = service.getWordOfTheDay("ace");
    }


//    public DictionaryViewModel(@NonNull Application application) {
//        super(application);
//
//    }

    public LiveData<Example> getResultObservable() {
        return resultObservable;
    }

}
