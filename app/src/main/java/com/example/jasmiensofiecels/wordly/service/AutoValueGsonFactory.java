package com.example.jasmiensofiecels.wordly.service;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

/**
 * The purpose of this class is to generate a factory to instantiate all AutoValue GSON classes.
 *
 * Created by Jasmien Cels on 05/04/2018.
 */

@GsonTypeAdapterFactory
public abstract class AutoValueGsonFactory implements TypeAdapterFactory {

    public static TypeAdapterFactory create() {
        return new AutoValueGson_AutoValueGsonFactory();
    }
}
