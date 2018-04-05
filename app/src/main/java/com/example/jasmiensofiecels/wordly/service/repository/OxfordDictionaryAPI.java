package com.example.jasmiensofiecels.wordly.service.repository;

import com.example.jasmiensofiecels.wordly.service.model.OxfordEntry.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * The purpose of this interface is to ....
 * Created by Jasmien Cels on 03/04/2018.
 */

public interface OxfordDictionaryAPI {

    @GET("entries/{source_lang}/{word_id}")
    Call<Example> getWordOfTheDay (
            @Header("Accept") String accept,
            @Header("app_id") String appId,
            @Header("app_key") String appKey,
            @Path("source_lang") String language,
            @Path("word_id") String wordID
    );
}
