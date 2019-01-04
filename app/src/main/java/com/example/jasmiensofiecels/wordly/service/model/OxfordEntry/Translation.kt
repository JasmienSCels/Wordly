package com.example.jasmiensofiecels.wordly.service.model.OxfordEntry

/**
 * Created by jcels on 03/01/2019.
 */
data class Translation(var domains: List<String>,
                       var grammaticalFeatures: List<GrammaticalFeature_>,
                       var language: String,
                       var notes: List<Note__>,
                       var regions: List<String>,
                       var registers: List<String>,
                       var text: String) {
}