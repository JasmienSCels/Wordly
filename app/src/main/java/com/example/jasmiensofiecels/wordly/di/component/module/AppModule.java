package com.example.jasmiensofiecels.wordly.di.component.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

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
    @Singleton
    public abstract Context bindContext(Application application);
}
