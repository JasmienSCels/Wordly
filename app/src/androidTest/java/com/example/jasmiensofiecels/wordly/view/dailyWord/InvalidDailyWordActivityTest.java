package com.example.jasmiensofiecels.wordly.view.dailyWord;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;

import com.example.jasmiensofiecels.wordly.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

/**
 * The purpose of this test class is to test the UI of the DailyWordActivity.
 * These tests focus on invalid search words.
 *
 * Created by Jasmien Cels on 20/04/2018.
 */

@RunWith(JUnit4.class)
public class InvalidDailyWordActivityTest {

    private String invalidInput;
    private String nullInput;
    private Activity activity;

    @Rule
    public ActivityTestRule<DailyWordActivity> rule = new ActivityTestRule<>(DailyWordActivity.class);

    @Before
    public void initInvalidSearch() {
        invalidInput = "invalidSpelling";
        nullInput = "";
        activity = rule.getActivity();
    }

    @Test
    //The purpose of this test is to ensure that the search EditText text is set to the invalid word
    public void searchWordIsInvalidWord() {

        //When
        onView(withId(R.id.search_word_et))
                .perform(typeText(invalidInput), closeSoftKeyboard());
        onView(withId(R.id.search_fab))
                .perform(click());

        try {
            Thread.sleep(500);
        } catch (Exception e) {
            Log.d("Thread exception: ", e.getMessage());
        }

        //Then
        onView(withId(R.id.search_word_et))
                .check(matches(withText(invalidInput)));
    }

    @Test
    //The purpose of this test is to ensure that the Toast appeared
    public void toastAppearedOnInvalidInput() {

        //When
        onView(withId(R.id.search_word_et))
                .perform(typeText(invalidInput), closeSoftKeyboard());
        onView(withId(R.id.search_fab))
                .perform(click());

        try {
            Thread.sleep(500);
        } catch (Exception e) {
            Log.d("Thread exception: ", e.getMessage());
        }
        //Then

        onView(withText("Word not found")).
                inRoot(withDecorView(not(is(activity.getWindow().getDecorView())))).
                check(matches(isDisplayed()));
    }

    @Test
    //The purpose of this test is to ensure that the search EditText is set to null
    public void searchWordIsNull() {
        //When
        onView(withId(R.id.search_word_et))
                .perform(typeText(nullInput));
        onView(withId(R.id.search_fab))
                .perform(click());

        //Then
        onView(withId(R.id.search_word_et))
                .check(matches(withText("")));
    }

    @Test
    //The purpose of this test is to ensure that a toast appears
    public void toastAppearedOnNullInput() {
        //When
        onView(withId(R.id.search_word_et))
                .perform(typeText(nullInput));
        onView(withId(R.id.search_fab))
                .perform(click());

        //Then
        onView(withText("Please enter a word")).
                inRoot(withDecorView(not(is(activity.getWindow().getDecorView())))).
                check(matches(isDisplayed()));
    }

    @Test
    //The purpose of this test is to ensure that the General word descriptions are set to their original state
    public void textViewsReset() {
        //When
        onView(withId(R.id.search_word_et))
                .perform(typeText(nullInput));
        onView(withId(R.id.search_fab))
                .perform(click());

        //Then
        onView(withId(R.id.defined_word_tv))
                .check(matches(withText("word")));
        onView(withId(R.id.word_phonetic))
                .check(matches(withText("Phonetic Spelling")));
        onView(withId(R.id.word_lexical_category))
                .check(matches(withText("Lexical Category")));
    }

    @Test
    //The purpose of this test is to ensure that the recyclerView is not displayed
    public void recyclerViewNotDisplayedOnInvalidInput() {
        //When
        onView(withId(R.id.search_word_et))
                .perform(typeText(nullInput));
        onView(withId(R.id.search_fab))
                .perform(click());

        onView(withId(R.id.recycler_view))
                .check(matches(not(isDisplayed())));
    }

}
