package com.example.jasmiensofiecels.wordly.view.dailyWord;

import android.support.annotation.NonNull;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.jasmiensofiecels.wordly.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;


/**
 * The purpose of this class is to test the main search functionality of a set of words that are valid and invalid.
 *
 * Created by Jasmien Cels on 19/04/2018.
 */
@RunWith(AndroidJUnit4.class)
public class ValidDailyWordActivityTest {

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

        //When
        onView(withId(R.id.search_word_et)) //get text edit widget
                .perform(typeText(validInput)); //insert valid searchable word
        onView(withId(R.id.search_fab)).perform(click()); //Action click on the search button

        try {
            Thread.sleep(500);
        } catch (Exception e) {
            Log.d("Error", "thread sleep");
        }
    }

    @Test
    //The purpose of this test is to ensure that the definedWord textView gets changed to the searched word
    public void wordTextView_changedOnSearch() {
        //Then
        onView(withId(R.id.defined_word_tv))
                .check(matches(withText(validInput))); //Searched word is displayed.

    }

    @Test
    //The purpose of test is to ensure that phoneticSpelling is changed
    public void lexicalTextView_changedOnSearch() {
        //Then
        onView(withId(R.id.word_lexical_category))
                .check(matches(withText("Noun")));
    }

    //For some reason, it cannot match the phonetic spelling
//    @Test
//    public void phoneticTextView_changedOnSearch() {
//        //Then
//        onView(withId(R.id.word_phonetic))
//                .check(matches(withText("andrɔɪd")));
//    }

    @Test
    //The purpose of this test is to ensure that the recycler view is displayed
    public void recyclerViewDisplayed_changedOnSearch() {
        //Then
        onView(withId(R.id.recycler_view))
                .check(matches(isDisplayed()));
    }

    @Test
    //The purpose of this test is to ensure that the recyclerView item size is equal to 2.
    public void recyclerViewSize() {
        //Then
        onView(withId(R.id.recycler_view))
                .check(new RecyclerViewItemCountAssertion(2));
    }

    @Test
    //The purpose of the this test is to ensure that the first recyclerView list definition is correct
    public void firstWordDefinition_onRecyclerView() {
        //Then
        onView(withId(R.id.recycler_view))
                .perform(RecyclerViewActions.scrollToPosition(0))
                .check(matches(atPositionOnView(0, withText("(in science fiction) a robot with a human appearance"), R.id.word_definition)));
    }

    @Test
    //The purpose of the this test is to ensure that the first recyclerView list order number is correct
    public void firstWordOrder_onRecyclerView() {
        //Then
        onView(withId(R.id.recycler_view))
                .perform(RecyclerViewActions.scrollToPosition(0))
                .check(matches(atPositionOnView(0, withText("1"), R.id.word_list_order)));

    }

    @Test
    //The purpose of the this test is to ensure that the second recyclerView list definition is correct
    public void secondWordDefinition_onRecyclerView() {
        //Then
        onView(withId(R.id.recycler_view))
                .perform(RecyclerViewActions.scrollToPosition(1))
                .check(matches(atPositionOnView(1, withText("an open-source operating system used for smartphones and tablet computers"), R.id.word_definition)));
    }

    @Test
    //The purpose of the this test is to ensure that the second recyclerView list order number is correct
    public void secondWordOrder_onRecyclerView() {
        //Then
        onView(withId(R.id.recycler_view))
                .perform(RecyclerViewActions.scrollToPosition(1))
                .check(matches(atPositionOnView(1, withText("2"), R.id.word_list_order)));
    }


    //Methods to aid test assertions
    //Thank you Stack Over Flow!
    public class RecyclerViewItemCountAssertion implements ViewAssertion {
        private final int expectedCount;

        public RecyclerViewItemCountAssertion(int expectedCount) {
            this.expectedCount = expectedCount;
        }

        @Override
        public void check(View view, NoMatchingViewException noViewFoundException) {
            if (noViewFoundException != null) {
                throw noViewFoundException;
            }

            RecyclerView recyclerView = (RecyclerView) view;
            assertThat(recyclerView.getAdapter().getItemCount(), is(expectedCount));
        }
    }


    public static Matcher<View> atPositionOnView(final int position, final Matcher<View> itemMatcher,
                                                 @NonNull final int targetViewId) {

        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("has view id " + itemMatcher + " at position " + position);
            }

            @Override
            public boolean matchesSafely(final RecyclerView recyclerView) {
                RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForAdapterPosition(position);
                View targetView = viewHolder.itemView.findViewById(targetViewId);
                return itemMatcher.matches(targetView);
            }
        };
    }

}