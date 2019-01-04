package com.example.jasmiensofiecels.wordly.service.model.OxfordEntry

/**
 * Created by jcels on 03/01/2019.
 */
data class Result(var id: String,
                  var language: String,
                  var lexicalEntries: List<LexicalEntry>,
                  var pronunciations: List<Pronunciation___>,
                  var type: String,
                  var word: String) {
}