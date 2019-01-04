package com.example.jasmiensofiecels.wordly.service.model.OxfordEntry

/**
 * Created by jcels on 03/01/2019.
 */
data class LexicalEntry(var derivativeOf: List<DerivativeOf>,
                        var derivatives: List<Derivative>,
                        var entries: List<Entry>,
                        var grammaticalFeature: List<GrammaticalFeature___>,
                        var language: String,
                        var lexicalCategory: String,
                        var notes: List<Note_____>,
                        var pronunciations: List<Pronunciation__>,
                        var text: String,
                        var variantForms: List<VariantForm__>) {
}