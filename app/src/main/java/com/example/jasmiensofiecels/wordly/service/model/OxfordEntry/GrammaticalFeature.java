package com.example.jasmiensofiecels.wordly.service.model.OxfordEntry;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jasmien Cels on 03/04/2018.
 */


@AutoValue
public class GrammaticalFeature {


    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("type")
    @Expose
    private String type;


    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public static TypeAdapter<GrammaticalFeature> typeAdapter(Gson gson) {
        return new AutoValue_GrammaticalFeature.GsonTypeAdapter(gson);
    }
}
