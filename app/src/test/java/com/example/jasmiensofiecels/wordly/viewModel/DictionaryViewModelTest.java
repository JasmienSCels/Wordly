package com.example.jasmiensofiecels.wordly.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.jasmiensofiecels.wordly.service.model.OxfordEntry.Example;
import com.example.jasmiensofiecels.wordly.service.repository.DictionaryRepository;
import com.example.jasmiensofiecels.wordly.view.dailyWord.DailyWordView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * The purpose of this class is to test the functionality of the DictionaryViewModel class.
 *
 *
 * Created by Jasmien Cels on 11/04/2018.
 */

@RunWith(JUnit4.class)
public class DictionaryViewModelTest {

//    @Rule
//    @JvmField


    private DictionaryViewModel viewModel;

    @Mock
    private DictionaryRepository repository;

    @Mock
    private DictionaryViewModelFactory factory;

    @Mock
    private DailyWordView view;



    @Before
    public void setup() {

        //Initialise mock objects
        MockitoAnnotations.initMocks(this);

        //Instantiate the viewModel
        //TODO: Is the underlying problem here?
        repository = new DictionaryRepository();

        viewModel = new DictionaryViewModel(repository);


        //When the repository is called, return an Example object.

    }

    @Test
    public void testDictionaryRepository_returnsExampleObject() {

        Log.d("Observable response", "test");
        MutableLiveData<String> testWord = new MutableLiveData<>();
        testWord.setValue("test");

        //Create the Example object mocked response.
        ExampleTest exampleTest = new ExampleTest();
        exampleTest.setTestExample("test");
        MutableLiveData<Example> testResponse = new MutableLiveData<>();
        testResponse.setValue(exampleTest.getTestExample());

        //When the repository object is called, return the above created ExampleTest object.
        Mockito.when(repository.getWordOfTheDay("en", testWord)).thenReturn(testResponse);
                //testResponse);

        MutableLiveData<String> word = new MutableLiveData<>();
        word.setValue("test");

        //When
        viewModel.onWordRefresh(word);

        //Then
        String resultId = viewModel.getResultObservable().getValue().getResults().get(0).getId();
        Mockito.verify(resultId).contentEquals("test");

    }

}