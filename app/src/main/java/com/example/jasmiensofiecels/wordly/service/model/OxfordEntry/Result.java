package com.example.jasmiensofiecels.wordly.service.model.OxfordEntry;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jasmien Cels on 03/04/2018.
 */



@AutoValue
public class Result {


    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("lexicalEntries")
    @Expose
    private List<LexicalEntry> lexicalEntries = null;
    @SerializedName("pronunciations")
    @Expose
    private List<Pronunciation___> pronunciations = null;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("word")
    @Expose
    private String word;


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getLanguage() {
        return language;
    }


    public void setLanguage(String language) {
        this.language = language;
    }


    public List<LexicalEntry> getLexicalEntries() {
        return lexicalEntries;
    }


    public void setLexicalEntries(List<LexicalEntry> lexicalEntries) {
        this.lexicalEntries = lexicalEntries;
    }


    public List<Pronunciation___> getPronunciations() {
        return pronunciations;
    }


    public void setPronunciations(List<Pronunciation___> pronunciations) {
        this.pronunciations = pronunciations;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public String getWord() {
        return word;
    }


    public void setWord(String word) {
        this.word = word;
    }

    public static TypeAdapter<Result> typeAdapter(Gson gson) {
        return new AutoValue_Result.GsonTypeAdapter(gson);
    }

}
