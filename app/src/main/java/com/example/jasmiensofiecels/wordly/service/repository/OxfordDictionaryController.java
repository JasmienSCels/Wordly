package com.example.jasmiensofiecels.wordly.service.repository;


import android.util.Log;

import com.example.jasmiensofiecels.wordly.service.model.OxfordEntry.Result;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The purpose of this class is to...
 *
 * Created by Jasmien Cels on 04/04/2018.
 */

public class OxfordDictionaryController implements Callback<Result> {

    private final String HTTPS_OXFORD_URL = "https://od-api.oxforddictionaries.com:443/api/v1/";

    public void start() {

        Log.d("Api call", "Is being called");
        //to serialize to gson
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HTTPS_OXFORD_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        OxfordDictionaryAPI oxfordDictionaryAPI = retrofit.create(OxfordDictionaryAPI.class);

//        Call<Result> call = oxfordDictionaryAPI.getWordOfTheDay("cda190b7", "fe4d42ccf21a2db3396e370769987348","en", "ace");
//        call.enqueue(this);
    }

    //Callback<Result> method implementations
    @Override
    public void onResponse(Call<Result> call, Response<Result> response) {
        Log.d("Api call", "Success");
        Log.d("Api response", response.body().getId());
    }

    @Override
    public void onFailure(Call<Result> call, Throwable t) {

    }
}
