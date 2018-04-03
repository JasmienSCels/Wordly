package com.example.jasmiensofiecels.wordly.service.model.OxfordEntry;

import java.util.List;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jasmien Cels on 03/04/2018.
 */

@AutoValue
public class Example_ {


    @SerializedName("definitions")
    @Expose
    private List<String> definitions = null;
    @SerializedName("domains")
    @Expose
    private List<String> domains = null;
    @SerializedName("notes")
    @Expose
    private List<Note_> notes = null;
    @SerializedName("regions")
    @Expose
    private List<String> regions = null;
    @SerializedName("registers")
    @Expose
    private List<String> registers = null;
    @SerializedName("senseIds")
    @Expose
    private List<String> senseIds = null;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("translations")
    @Expose
    private List<Translation> translations = null;


    public List<String> getDefinitions() {
        return definitions;
    }


    public void setDefinitions(List<String> definitions) {
        this.definitions = definitions;
    }


    public List<String> getDomains() {
        return domains;
    }


    public void setDomains(List<String> domains) {
        this.domains = domains;
    }


    public List<Note_> getNotes() {
        return notes;
    }


    public void setNotes(List<Note_> notes) {
        this.notes = notes;
    }


    public List<String> getRegions() {
        return regions;
    }


    public void setRegions(List<String> regions) {
        this.regions = regions;
    }


    public List<String> getRegisters() {
        return registers;
    }


    public void setRegisters(List<String> registers) {
        this.registers = registers;
    }


    public List<String> getSenseIds() {
        return senseIds;
    }


    public void setSenseIds(List<String> senseIds) {
        this.senseIds = senseIds;
    }


    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }


    public List<Translation> getTranslations() {
        return translations;
    }


    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }

    public static TypeAdapter<Example_> typeAdapter(Gson gson) {
        return new AutoValue_Example_.GsonTypeAdapter(gson);
    }

}
