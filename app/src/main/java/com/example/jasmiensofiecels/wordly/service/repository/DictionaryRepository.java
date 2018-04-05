package com.example.jasmiensofiecels.wordly.service.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.jasmiensofiecels.wordly.service.model.OxfordEntry.Example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * The purpose of this class is to ....
 * Created by Jasmien Cels on 03/04/2018.
 */

public class DictionaryRepository {

    private String langauge = "en";

    private final String HTTPS_OXFORD_URL = "https://od-api.oxforddictionaries.com:443/api/v1/";

    public LiveData<Example> getWordOfTheDay(String wordID) {

        final MutableLiveData<Example> results = new MutableLiveData<>();

        Log.d("Api call", "Is being called");
        //to serialize to gson
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HTTPS_OXFORD_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        OxfordDictionaryAPI oxfordDictionaryAPI = retrofit.create(OxfordDictionaryAPI.class);

        Call<Example> call = oxfordDictionaryAPI.getWordOfTheDay( "application/json","cda190b7", "fe4d42ccf21a2db3396e370769987348","en", "ace");
        call.enqueue(new Callback<Example>() {

            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.d("repository response", String.valueOf(response.isSuccessful()));
                results.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d("repository response", "Failure: " + t.getMessage());

            }
        });

//        service.getWordOfTheDay(Credentials.basic("Jasmien Cels's App", "cda190b7" ),langauge, wordID).enqueue(new Callback<Result>() {
//            @Override
//            public void onResponse(Call<Result> call, Response<Result> response) {
//                Log.d("repository response", response.body().getId());
//                results.setValue(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<Result> call, Throwable t) {
//
//            }
//
//            //TODO: Error Handeling
//
//
//        });

        return results;
    }
}
