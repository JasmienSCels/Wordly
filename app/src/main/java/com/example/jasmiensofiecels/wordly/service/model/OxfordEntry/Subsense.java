package com.example.jasmiensofiecels.wordly.service.model.OxfordEntry;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

/**
 * Created by Jasmien Cels on 03/04/2018.
 */

@AutoValue
public class Subsense {


    public static TypeAdapter<Subsense> typeAdapter(Gson gson) {
        return new AutoValue_Subsense.GsonTypeAdapter(gson);
    }


}
