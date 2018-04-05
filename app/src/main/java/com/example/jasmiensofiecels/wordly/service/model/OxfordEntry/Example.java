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
public class Example {


    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;


    public Metadata getMetadata() {
        return metadata;
    }


    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }


    public List<Result> getResults() {
        return results;
    }


    public void setResults(List<Result> results) {
        this.results = results;
    }

    public static TypeAdapter<Example> typeAdapter(Gson gson) {
        return new AutoValue_Example.GsonTypeAdapter(gson);
    }


}
