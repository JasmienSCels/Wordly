package com.example.jasmiensofiecels.wordly.view.dailyWord;

import android.app.Application;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jasmiensofiecels.wordly.R;
import com.example.jasmiensofiecels.wordly.service.model.OxfordEntry.Example;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * The purpose of this class is to create the recycler view.
 * Once a word has been searched for, the different variations of the word will be
 * displayed on
 *
 * The purpose of the ViewHolder class is represent the UI and UI logic for each individual
 * sub view.
 *
 * Created by Jasmien Cels on 13/04/2018.
 */

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.ViewHolder>  {


    @Inject
    Application application;

    private Example response;
    private ArrayList<String> wordDefinitions;

    public WordListAdapter(Example response) {
        this.response = response;

        wordDefinitions = getSenseDefinitions();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.word_definition_card, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.setDataOnCard(i+1, wordDefinitions.get(i));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.setDataOnCard(i+1, wordDefinitions.get(i));
    }

    @Override
    public int getItemCount() {

        int subDefinitionCount = 0;
        for(int i = 0; i < response.getResults().get(0).getLexicalEntries().size(); i++) {
            if(!response.getResults().get(0).getLexicalEntries().get(i).getEntries().get(0).getSenses().get(0).getDefinitions().get(0).isEmpty()) {
                subDefinitionCount += response.getResults().get(0).getLexicalEntries().get(i).getEntries().get(0).getSenses().size();
            }
        }
        return subDefinitionCount;
    }

    public ArrayList<String> getSenseDefinitions() {

        ArrayList<String> definitions = new ArrayList<>();

        //Loop through the main forms of definitions; this does not get the sub-definitions;
        for(int i = 0; i < response.getResults().get(0).getLexicalEntries().size(); i++) {
            if(!response.getResults().get(0).getLexicalEntries().get(i).getEntries().get(0).getSenses().get(0).getDefinitions().get(0).isEmpty()) {
                for(int s = 0; s < response.getResults().get(0).getLexicalEntries().get(i).getEntries().get(0).getSenses().size(); s++) {
                        if (!response.getResults().get(0).getLexicalEntries().get(i).getEntries().get(0).getSenses().isEmpty()) {
                            if(!response.getResults().get(0).getLexicalEntries().get(i).getEntries().get(0).getSenses().get(s).getDefinitions().get(0).isEmpty()) {
                                Log.d("sense", response.getResults().get(0).getLexicalEntries().get(i).getEntries().get(0).getSenses().get(s).getDefinitions().get(0).toString());
                                String subDefinition = response.getResults().get(0).getLexicalEntries().get(i).getEntries().get(0).getSenses().get(s).getDefinitions().get(0);
                                definitions.add(subDefinition);
                            }
                        }
                }
            }
        }
       return definitions;
    }

    /*
     * The purpose of this class is to represent the individual views for each word
     * definition.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.word_list_order)
        TextView wordOrder;

        @BindView(R.id.word_definition)
        TextView wordDefinition;

        private ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setDataOnCard(int order, String definition) {
            wordOrder.setText(String.valueOf(order));
            wordDefinition.setText(definition);
        }
    }

}
