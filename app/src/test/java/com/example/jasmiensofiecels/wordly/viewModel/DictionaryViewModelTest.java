package com.example.jasmiensofiecels.wordly.viewModel;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.MutableLiveData;

import com.example.jasmiensofiecels.wordly.service.model.OxfordEntry.Example;
import com.example.jasmiensofiecels.wordly.service.repository.DictionaryRepository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;


/**
 * The purpose of this class is to test the functionality of the DictionaryViewModel class.
 *
 * Created by Jasmien Cels on 11/04/2018.
 */

@RunWith(JUnit4.class)
public class DictionaryViewModelTest {

    @Rule
    //A JUnit Test Rule that swaps the background executor used by the Architecture Components
    // with a different one which executes each task synchronously.
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    private DictionaryViewModel viewModel;

    @Mock
    private DictionaryRepository repository;

    @Mock
    private android.arch.lifecycle.Observer<Example> observer;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        viewModel = new DictionaryViewModel(repository);
    }

    @Test
    //The purpose of this test is ensure that the viewModel is calling the appropriate repository method
    public void verifyViewModelCallsRepository() {
        viewModel.getResultObservable().observeForever(observer);

        MutableLiveData<String> word = new MutableLiveData<>();
        word.postValue("word");

        //When
        viewModel.onWordRefresh(word);

        //Then
        verify(repository).getWordOfTheDay("en", word);
    }

    @Test
    //The purpose of this test is ensure that the viewModel is calling the appropriate repository method
    public void verifyNullInputViewModelCallRepository() {
        viewModel.getResultObservable().observeForever(observer);

        //when
        viewModel.onWordRefresh(null);

        //Then
        verify(repository).getWordOfTheDay("en", null);
    }
}