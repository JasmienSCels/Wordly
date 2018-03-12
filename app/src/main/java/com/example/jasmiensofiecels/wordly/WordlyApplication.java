package com.example.jasmiensofiecels.wordly;

import android.app.Activity;
import android.app.Application;

import com.example.jasmiensofiecels.wordly.view.di.component.ApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * The purpose of this class is to
 * Created by jasmiensofiecels on 12/03/2018.
 */

public class WordlyApplication extends Application implements HasActivityInjector {


    private ApplicationComponent applicationComponent;


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return null;
    }
}
