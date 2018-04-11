package com.example.jasmiensofiecels.wordly;

import android.app.Activity;
import android.app.Application;

import com.example.jasmiensofiecels.wordly.di.component.component.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * The purpose of this class is to represent the entry point for the dependency injection.
 * Activities are presented here to participate in the injection process.
 * Created by Jasmiens Cels on 12/03/2018.
 */

public class WordlyApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerApplicationComponent.builder()
                .contextPasser(this)
                //.baseUrlModule(new BaseUrlModule("http://10.0.2.2:3000"))
                .applicationPasser()
                .inject(this);

    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }

}
