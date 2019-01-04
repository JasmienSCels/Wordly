package com.example.jasmiensofiecels.wordly.service.model.OxfordEntry

/**
 * Created by jcels on 03/01/2019.
 */
data class Derivative(var domains :List<String>,
                      var id :String,
                      var language: String,
                      var regions :List<String>,
                      var registers: List<String>,
                      var text: String) {
}