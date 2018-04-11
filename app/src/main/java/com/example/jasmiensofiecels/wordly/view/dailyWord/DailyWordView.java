package com.example.jasmiensofiecels.wordly.view.dailyWord;

import com.example.jasmiensofiecels.wordly.service.model.OxfordEntry.Example;
import com.example.jasmiensofiecels.wordly.view.base.BaseView;

/**
 * The purpose of this interface is to present the methods that must be implemented by the activity.
 *
 * Created by jcels on 23/03/2018.
 */

public interface DailyWordView extends BaseView {

    void renderWordOfTheDay(Example response);

    void refreshWordOfTheDay();

}
