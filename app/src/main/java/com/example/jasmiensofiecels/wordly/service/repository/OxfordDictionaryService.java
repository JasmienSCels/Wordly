package com.example.jasmiensofiecels.wordly.service.repository;

import com.example.jasmiensofiecels.wordly.service.model.OxfordEntry.Entry;
import com.example.jasmiensofiecels.wordly.service.model.OxfordEntry.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * The purpose of this interface is to ....
 * Created by Jasmien Cels on 03/04/2018.
 */

public interface OxfordDictionaryService {

    String HTTPS_OXFORD_URL = "https://od-api.oxforddictionaries.com:443/api/v1/";

    @GET(":443/api/v1/entries/{language}/{wordID}")
    Call<Result> getWordOfTheDay (
            @Path("language") String language,
            @Path("wordID") String wordID
    );
}
