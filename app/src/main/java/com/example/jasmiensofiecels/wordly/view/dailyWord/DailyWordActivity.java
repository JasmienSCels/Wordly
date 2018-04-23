package com.example.jasmiensofiecels.wordly.view.dailyWord;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jasmiensofiecels.wordly.R;
import com.example.jasmiensofiecels.wordly.service.model.OxfordEntry.Example;
import com.example.jasmiensofiecels.wordly.view.base.BaseActivity;
import com.example.jasmiensofiecels.wordly.viewModel.DictionaryViewModel;
import com.example.jasmiensofiecels.wordly.viewModel.DictionaryViewModelFactory;
import com.github.clans.fab.FloatingActionButton;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

/*
 * The purpose of this activity class is to display the word of the day to the user.
 * User input is delegated to the viewModel to retrieve a word definition.
 *
 * Created by Jasmien Cels on 23/03/2018.
 */

public class DailyWordActivity extends BaseActivity implements DailyWordView {

    @Inject
    DictionaryViewModelFactory factory;

    //UI Widgets
    @BindView(R.id.search_fab)
    FloatingActionButton searchFab;

    @BindView(R.id.search_word_et)
    EditText searchTv;

    @BindView(R.id.defined_word_tv)
    TextView wordTitle;

    @BindView(R.id.word_phonetic)
    TextView wordPhonetic;

    @BindView(R.id.word_lexical_category)
    TextView wordLexical;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private DictionaryViewModel viewModel;
    private WordListAdapter listAdapter;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_word);
        ButterKnife.bind(this);

        linearLayoutManager = new LinearLayoutManager(this);

        //Create the view model, which is injected via the factory.
        viewModel = ViewModelProviders.of(this, factory).get(DictionaryViewModel.class);
        observeViewModel(viewModel);

        searchFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MutableLiveData<String> wordChange = new MutableLiveData<>();

                //Check against null inputs
                if(searchTv.getText().toString().equals("")) {
                    renderInvalidSearchInput("Please enter a word");
                    return;
                }
                wordChange.setValue(searchTv.getText().toString());
                viewModel.onWordRefresh(wordChange);

                //TODO: why do I need to observe again??? Scope?
                observeViewModel(viewModel);
            }
        });
    }

    private void observeViewModel(final DictionaryViewModel viewModel) {
        viewModel.getResultObservable().observe(this, new Observer<Example>() {
            @Override
            public void onChanged(@Nullable Example response) {
                if(response == null) {
                    renderInvalidSearchInput("Word not found");
                    return;
                }
                renderWordInformation(response);
            }
        });
    }

    @Override
    public void renderWordInformation(Example response) {
        wordTitle.setText(response.getResults().get(0).getId());
        wordPhonetic.setText(response.getResults().get(0).getLexicalEntries().get(0).getPronunciations().get(0).getPhoneticSpelling());
        wordLexical.setText(response.getResults().get(0).getLexicalEntries().get(0).getLexicalCategory());

        //Set up the recycler view to display the definition variations
        recyclerView.setLayoutManager(linearLayoutManager);
        listAdapter = new WordListAdapter(response);
        recyclerView.setAdapter(listAdapter);

        //Remove previous dividerItemDecoration, otherwise the padding will keep growing in-between cards.
        recyclerView.removeItemDecoration(dividerItemDecoration);

        //Add a divider between each definition
        dividerItemDecoration = new DividerItemDecoration(
                recyclerView.getContext(),
                linearLayoutManager.getOrientation()
        );
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAlpha(1); //visable
    }

    public void renderInvalidSearchInput(String message) {
        //remove previous search information
        wordTitle.setText(wordTitle.getHint());
        wordPhonetic.setText(wordPhonetic.getHint());
        wordLexical.setText(wordLexical.getHint());
        recyclerView.setAlpha(0); //invisable
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
