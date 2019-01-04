package com.example.jasmiensofiecels.wordly.service.model.OxfordEntry

/**
 * Created by jcels on 03/01/2019.
 */
data class Translation_(var domains: List<String>,
                       var grammaticalFeatures: List<GrammaticalFeature__>,
                       var language: String,
                       var notes: List<Note___>,
                       var regions: List<String>,
                       var registers: List<String>,
                       var text: String) {
}