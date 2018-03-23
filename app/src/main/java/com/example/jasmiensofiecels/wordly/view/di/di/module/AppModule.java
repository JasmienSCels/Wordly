package com.example.jasmiensofiecels.wordly.view.di.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * The purpose of this class is to
 *
 * Created by Jasmien Cels on 23/03/2018.
 */

@Module
public abstract class AppModule {

    @Binds
    public abstract Context bindContext(Application application);
}
