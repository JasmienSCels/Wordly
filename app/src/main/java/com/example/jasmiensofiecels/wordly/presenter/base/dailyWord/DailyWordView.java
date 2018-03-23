package com.example.jasmiensofiecels.wordly.presenter.base.dailyWord;

import com.example.jasmiensofiecels.wordly.presenter.base.base.BaseView;

/**
 * The purpose of this interface is to present the methods that must be implemented by the activity.
 *
 * Created by jcels on 23/03/2018.
 */

public interface DailyWordView extends BaseView {

    void renderWordOfTheDay();

    void refreshWordOfTheDay();

}
