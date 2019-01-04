package com.example.jasmiensofiecels.wordly.view.dailyWord;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jasmiensofiecels.wordly.R;
import com.example.jasmiensofiecels.wordly.service.model.OxfordEntry.Example;
import com.example.jasmiensofiecels.wordly.service.model.Room.Entities.StarredWord;
import com.example.jasmiensofiecels.wordly.view.base.BaseActivity;
import com.example.jasmiensofiecels.wordly.viewModel.DictionaryViewModel;
import com.example.jasmiensofiecels.wordly.viewModel.DictionaryViewModelFactory;
import com.github.clans.fab.FloatingActionButton;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

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
    @BindView(R.id.toolbar)
    @javax.annotation.Nullable
    Toolbar toolbar;

    @BindView(R.id.search_fab)
    @Nullable
    FloatingActionButton searchFab;

    @BindView(R.id.search_word_et)
    @Nullable
    EditText searchTv;

    @BindView(R.id.starBtn)
    @Nullable
    ImageButton starButton;

    @BindView(R.id.defined_word_tv)
    @Nullable
    TextView wordTitle;

    @BindView(R.id.word_phonetic)
    @Nullable
    TextView wordPhonetic;

    @BindView(R.id.recycler_view)
    @Nullable
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

        //Hide Soft Keyboard until an EditText View is clicked
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );

        //Use RxBinding for a reactive change of WordTitle to the searchTv
        RxTextView
                .textChanges(searchTv)
                .subscribe(new Action1<CharSequence>() {
                    @Override
                    public void call(CharSequence charSequence) {
                        wordTitle.setText(charSequence);
                     }
                });

        searchFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MutableLiveData<String> wordChange = new MutableLiveData<>();

                //Hide  keyboard
                if (getCurrentFocus() != null) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }

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


       //Add multiple click listeners on the star by using the composite subscription.
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        Observable<Void> starObservable = RxView.clicks(starButton).share();

        Subscription starColorChanger = starObservable.subscribe(new Action1<Void>() {
           @Override
           public void call(Void aVoid) {
               if(starButton.getColorFilter() == null) {
                   starButton.setColorFilter(getResources().getColor(R.color.colorAccent));
               } else {
                   starButton.setColorFilter(null);
               }
           }
        });
        compositeSubscription.add(starColorChanger);

        Subscription starSaved = starObservable.subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                if(searchTv != null) {
                    viewModel.getStarredWords();
                    List<StarredWord> words = viewModel.getStarredWordSingle();
                    Log.d("Retrieved words", words.toString());
                }
            }
        });
        compositeSubscription.add(starSaved);
    }

    public void observeViewModel(final DictionaryViewModel viewModel) {
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

        //Set up the recycler view to display the definition variations
        recyclerView.setLayoutManager(linearLayoutManager);
        listAdapter = new WordListAdapter(response);
        recyclerView.setAdapter(listAdapter);

        //Remove previous dividerItemDecoration, otherwise the padding will keep growing in-between cards as the number of searches increases.
        recyclerView.removeItemDecoration(dividerItemDecoration);

        //Add a divider between each definition
        dividerItemDecoration = new DividerItemDecoration(
                recyclerView.getContext(),
                linearLayoutManager.getOrientation()
        );
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAlpha(1); //visible
    }

    public void renderInvalidSearchInput(String message) {
        //remove previous search information
        wordTitle.setText(wordTitle.getHint());
        wordPhonetic.setText(wordPhonetic.getHint());
        recyclerView.setAlpha(0); //invisible
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
