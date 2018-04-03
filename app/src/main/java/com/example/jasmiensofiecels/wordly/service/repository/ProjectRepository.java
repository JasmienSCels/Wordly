package com.example.jasmiensofiecels.wordly.service.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.jasmiensofiecels.wordly.service.model.OxfordEntry.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jasmien Cels on 03/04/2018.
 */

public class ProjectRepository {

    private OxfordDictionaryService service;

    private String langauge = "en";
    private String wordId = "";

    public LiveData<Result> getWordOfTheDay(String wordID) {

        final MutableLiveData<Result> results = new MutableLiveData<>();

        service.getWordOfTheDay(langauge, wordID).enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                results.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }

            //TODO: Error Handeling
        });

        return results;
    }
}
