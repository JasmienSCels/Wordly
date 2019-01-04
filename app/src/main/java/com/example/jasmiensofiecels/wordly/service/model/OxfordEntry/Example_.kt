package com.example.jasmiensofiecels.wordly.service.model.OxfordEntry

/**
 * Created by jcels on 03/01/2019.
 */
data class Example_(var definitions: List<String>,
                    var domains: List<String>,
                    var notes: List<Note_>,
                    var regions: List<String>,
                    var registers: List<String>,
                    var senseIds: List<String>,
                    var text: String,
                    var translations: List<Translation>) {
}