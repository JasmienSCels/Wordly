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
public class Sense {


    @SerializedName("crossReferenceMarkers")
    @Expose
    private List<String> crossReferenceMarkers = null;
    @SerializedName("crossReferences")
    @Expose
    private List<CrossReference> crossReferences = null;
    @SerializedName("definitions")
    @Expose
    private List<String> definitions = null;
    @SerializedName("domains")
    @Expose
    private List<String> domains = null;
    @SerializedName("examples")
    @Expose
    private List<Example_> examples = null;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("notes")
    @Expose
    private List<Note___> notes = null;
    @SerializedName("pronunciations")
    @Expose
    private List<Pronunciation_> pronunciations = null;
    @SerializedName("regions")
    @Expose
    private List<String> regions = null;
    @SerializedName("registers")
    @Expose
    private List<String> registers = null;
    @SerializedName("subsenses")
    @Expose
    private List<Subsense> subsenses = null;
    @SerializedName("translations")
    @Expose
    private List<Translation_> translations = null;
    @SerializedName("variantForms")
    @Expose
    private List<VariantForm> variantForms = null;


    public List<String> getCrossReferenceMarkers() {
        return crossReferenceMarkers;
    }


    public void setCrossReferenceMarkers(List<String> crossReferenceMarkers) {
        this.crossReferenceMarkers = crossReferenceMarkers;
    }


    public List<CrossReference> getCrossReferences() {
        return crossReferences;
    }


    public void setCrossReferences(List<CrossReference> crossReferences) {
        this.crossReferences = crossReferences;
    }


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


    public List<Example_> getExamples() {
        return examples;
    }


    public void setExamples(List<Example_> examples) {
        this.examples = examples;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public List<Note___> getNotes() {
        return notes;
    }


    public void setNotes(List<Note___> notes) {
        this.notes = notes;
    }


    public List<Pronunciation_> getPronunciations() {
        return pronunciations;
    }


    public void setPronunciations(List<Pronunciation_> pronunciations) {
        this.pronunciations = pronunciations;
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


    public List<Subsense> getSubsenses() {
        return subsenses;
    }


    public void setSubsenses(List<Subsense> subsenses) {
        this.subsenses = subsenses;
    }


    public List<Translation_> getTranslations() {
        return translations;
    }


    public void setTranslations(List<Translation_> translations) {
        this.translations = translations;
    }


    public List<VariantForm> getVariantForms() {
        return variantForms;
    }


    public void setVariantForms(List<VariantForm> variantForms) {
        this.variantForms = variantForms;
    }

    public static TypeAdapter<Sense> typeAdapter(Gson gson) {
        return new AutoValue_Sense.GsonTypeAdapter(gson);
    }


}
