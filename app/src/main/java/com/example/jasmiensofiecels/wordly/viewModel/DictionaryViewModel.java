package com.example.jasmiensofiecels.wordly.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.jasmiensofiecels.wordly.service.model.OxfordEntry.Example;
import com.example.jasmiensofiecels.wordly.service.model.Room.Entities.StarredWord;
import com.example.jasmiensofiecels.wordly.service.model.Room.repository.StarredWordRepository;
import com.example.jasmiensofiecels.wordly.service.repository.DictionaryRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * The purpose of this class is to represent the viewModel that gets observed by the view
 * and calls the model (DictionaryRepository) to get data.
 *
 * Created by Jasmien Cels on 04/04/2018.
 */

public class DictionaryViewModel extends ViewModel {

    public DictionaryRepository repository;
    private final StarredWordRepository starredWordRepository;

    private CompositeDisposable compositeDisposable;
    public static MutableLiveData<Example> resultObservable = new MutableLiveData<>();

    public List<StarredWord> starredWordSingle;

    @Inject
    public DictionaryViewModel(DictionaryRepository repository, StarredWordRepository starredWordRepository) {
        this.repository = repository;
        this.starredWordRepository = starredWordRepository;
        compositeDisposable = new CompositeDisposable();
    }

    public void onWordRefresh(MutableLiveData<String> word) {
        resultObservable = repository.getWordOfTheDay("en", word);
    }

    public LiveData<Example> getResultObservable() {
        return resultObservable;
    }

    public void getStarredWords() {
        Disposable starredWordDisposable = (Disposable) starredWordRepository.getAllStarredWords()
                                                                .subscribeOn(Schedulers.io())
                                                                .observeOn(AndroidSchedulers.mainThread())
                                                                .subscribe(this::onStarredWordsFetched, this::onStarredWordsFetchedError);

        compositeDisposable.add(starredWordDisposable);
    }

    public void onStarredWordsFetched(List<StarredWord> words) {
        starredWordSingle = words;
    }

    public void onStarredWordsFetchedError(Throwable throwable) {
        Log.d("Error", throwable.getMessage());
    }

    public List<StarredWord> getStarredWordSingle() {
        return starredWordSingle;
    }


}
