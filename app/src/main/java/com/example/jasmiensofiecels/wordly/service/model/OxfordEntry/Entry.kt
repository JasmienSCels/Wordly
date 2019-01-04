package com.example.jasmiensofiecels.wordly.service.model.OxfordEntry

/**
 * Created by jcels on 03/01/2019.
 */
data class Entry(var etymologies: List<String>,
                 var grammaticalFeatures: List<GrammaticalFeature>,
                 var homographNumber: String,
                 var notes: List<Note>,
                 var pronunciations: List<Pronunciation>,
                 var senses: List<Sense>,
                 var varientForms: List<VariantForm_>) {
}