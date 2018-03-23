package com.example.jasmiensofiecels.wordly.view.di.di.component;

import android.app.Application;

import com.example.jasmiensofiecels.wordly.WordlyApplication;
import com.example.jasmiensofiecels.wordly.view.di.di.module.ActivityBindingModule;
import com.example.jasmiensofiecels.wordly.view.di.di.module.AppModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * The purpose of this interface is to represent the injector class.
 * It will build the component graph, which will provided injected instances through modules.
 *
 * Created by Jasmien Cels on 12/03/2018.
 */

@Component(modules = {AndroidInjectionModule.class, ActivityBindingModule.class, AppModule.class})
public interface ApplicationComponent extends AndroidInjector<WordlyApplication> {

    //Bind instances to the component.
    @Component.Builder
    interface Builder {

        @BindsInstance
        public Builder contextPasser(Application application);

        public ApplicationComponent applicationPasser();

    }

}
