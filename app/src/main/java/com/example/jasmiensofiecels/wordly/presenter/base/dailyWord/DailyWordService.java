package com.example.jasmiensofiecels.wordly.presenter.base.dailyWord;

/**
 * The purpose of this interface is to represent the contract that must be implemented by the Presenter.
 *
 * Created by Jasmien Cels on 23/03/2018.
 */

public interface DailyWordService {


    void getWordOfTheDay(ResponseListener listener);

    interface ResponseListener {

        void onSuccess();

        void onFailure();

    }
}
