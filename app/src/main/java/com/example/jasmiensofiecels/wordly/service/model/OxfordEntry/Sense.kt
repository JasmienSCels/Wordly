package com.example.jasmiensofiecels.wordly.service.model.OxfordEntry

/**
 * Created by jcels on 03/01/2019.
 */
data class Sense(var crossReferenceMarkers: List<String>,
                 var crossReferences: List<CrossReference>,
                 var definitions: List<String>,
                 var domains: List<String>,
                 var examples: List<Example_>,
                 var id: String,
                 var notes: List<Note___>,
                 var pronunciations: List<Pronunciation_>,
                 var regions: List<String>,
                 var registers: List<String>,
                 var subsenses: List<Subsense>,
                 var translations: List<Translation_>,
                 var variantForm: List<VariantForm>) {
}