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
public class Pronunciation {


    @SerializedName("audioFile")
    @Expose
    private String audioFile;
    @SerializedName("dialects")
    @Expose
    private List<String> dialects = null;
    @SerializedName("phoneticNotation")
    @Expose
    private String phoneticNotation;
    @SerializedName("phoneticSpelling")
    @Expose
    private String phoneticSpelling;
    @SerializedName("regions")
    @Expose
    private List<String> regions = null;


    public String getAudioFile() {
        return audioFile;
    }


    public void setAudioFile(String audioFile) {
        this.audioFile = audioFile;
    }


    public List<String> getDialects() {
        return dialects;
    }


    public void setDialects(List<String> dialects) {
        this.dialects = dialects;
    }


    public String getPhoneticNotation() {
        return phoneticNotation;
    }


    public void setPhoneticNotation(String phoneticNotation) {
        this.phoneticNotation = phoneticNotation;
    }


    public String getPhoneticSpelling() {
        return phoneticSpelling;
    }


    public void setPhoneticSpelling(String phoneticSpelling) {
        this.phoneticSpelling = phoneticSpelling;
    }


    public List<String> getRegions() {
        return regions;
    }


    public void setRegions(List<String> regions) {
        this.regions = regions;
    }


    public static TypeAdapter<Pronunciation> typeAdapter(Gson gson) {
        return new AutoValue_Pronunciation.GsonTypeAdapter(gson);
    }
}
