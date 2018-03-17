package com.example.jasmiensofiecels.wordly;

import android.app.Activity;
import android.app.Application;

import com.example.jasmiensofiecels.wordly.view.di.component.ApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * The purpose of this class is to represent the entry point for the dependency injection.
 * Activities are presented here to participate in the injection process.
 * Created by jasmiensofiecels on 12/03/2018.
 */

public class WordlyApplication extends Application implements HasActivityInjector {


    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public AndroidInjector<Activity> activityInjector() {

        return activityInjector;
    }

}
