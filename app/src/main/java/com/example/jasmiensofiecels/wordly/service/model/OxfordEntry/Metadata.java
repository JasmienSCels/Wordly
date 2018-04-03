package com.example.jasmiensofiecels.wordly.service.model.OxfordEntry;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

/**
 * Created by jcels on 03/04/2018.
 */

@AutoValue
public class Metadata {


    public static TypeAdapter<Metadata> typeAdapter(Gson gson) {
        return new AutoValue_Metadata.GsonTypeAdapter(gson);
    }


}