package com.example.jasmiensofiecels.wordly.view.dailyWord;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.jasmiensofiecels.wordly.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * The purpose of this class is to test the main search functionality of a set of words that are valid and invalid.
 *
 * Created by Jasmien Cels on 19/04/2018.
 */
@RunWith(AndroidJUnit4.class)
public class DailyWordActivityTest {

    private String validInput;

    /*
     * The purpose of the rule is to provide functional testing of a single activity.
     * This provides access to the activity and its components by launching the activity in
     * a test environment.
     */
    @Rule
    public ActivityTestRule<DailyWordActivity> rule = new ActivityTestRule<>(DailyWordActivity.class);

    @Before
    public void initValidSearch() {
        validInput = "android";
    }

    @Test
    public void recyclerView_isViable(){
        //When
        onView(withId(R.id.search_word_et)) //get text edit widget
                .perform(typeText(validInput), closeSoftKeyboard()); //insert valid searchable word
        onView(withId(R.id.search_fab)).perform(click()); //Action click on the search button

        //Then
        onView(withId(R.id.recycler_view))
                .check(matches(isDisplayed())); //Recycler view is displayed.

    }



}