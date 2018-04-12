package com.example.jasmiensofiecels.wordly.service.repository;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.jasmiensofiecels.wordly.service.model.OxfordEntry.Example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The purpose of this class is to call the Oxford Dictionary API and
 * return a Gson Example object to the observable's subscriber.
 *
 * Created by Jasmien Cels on 03/04/2018.
 */

@Singleton
public class DictionaryRepository {

    @Inject
    public DictionaryRepository() {}

    private final String HTTPS_OXFORD_URL = "https://od-api.oxforddictionaries.com:443/api/v1/";

    public MutableLiveData<Example> getWordOfTheDay(String sourceLang,  MutableLiveData<String> wordID) {

        final MutableLiveData<Example> results = new MutableLiveData<>();

        //Serialize to Gson
        Gson gson = new GsonBuilder().setLenient().create();

        //Set up Retrofit call
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HTTPS_OXFORD_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        OxfordDictionaryAPI oxfordDictionaryAPI = retrofit.create(OxfordDictionaryAPI.class);

        //Convert MutableLiveData to String
        String word = wordID.getValue();

        //API call for word entry
        //TODO: Store id and key in string file.
        Call<Example> call = oxfordDictionaryAPI.getWordOfTheDay( "application/json","cda190b7", "fe4d42ccf21a2db3396e370769987348", sourceLang, word);
        call.enqueue(new Callback<Example>() {

            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if(response.body() == null) {
                    results.setValue(null);
                    return;
                }
                Log.d("repository response", response.body().getResults().get(0).getWord());
                results.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d("repository response", "Failure: " + t.getMessage());

            }
            //TODO: Error Handeling
        });

        return results;
    }
}
