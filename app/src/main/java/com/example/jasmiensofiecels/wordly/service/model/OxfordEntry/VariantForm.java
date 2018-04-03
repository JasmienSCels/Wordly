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
public class VariantForm {


    @SerializedName("regions")
    @Expose
    private List<String> regions = null;
    @SerializedName("text")
    @Expose
    private String text;


    public List<String> getRegions() {
        return regions;
    }


    public void setRegions(List<String> regions) {
        this.regions = regions;
    }


    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }


    public static TypeAdapter<VariantForm> typeAdapter(Gson gson) {
        return new AutoValue_VariantForm.GsonTypeAdapter(gson);
    }
}
