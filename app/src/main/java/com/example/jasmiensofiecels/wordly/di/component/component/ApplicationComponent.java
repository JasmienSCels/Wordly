package com.example.jasmiensofiecels.wordly.di.component.component;

import android.app.Application;

import com.example.jasmiensofiecels.wordly.WordlyApplication;
import com.example.jasmiensofiecels.wordly.di.component.module.ActivityBindingModule;
import com.example.jasmiensofiecels.wordly.di.component.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * The purpose of this interface is to represent the dependency graph.
 * It will build the component graph, bridging the gap between Inject and Module.
 * Provides the dependencies for classes that request them.
 *
 * Created by Jasmien Cels on 12/03/2018.
 */

@Component(modules = {AndroidInjectionModule.class, ActivityBindingModule.class, AppModule.class})
@Singleton
public interface ApplicationComponent extends AndroidInjector<WordlyApplication> {

    //Bind instances to the component.
    @Component.Builder
    interface Builder {

        @BindsInstance
        public Builder contextPasser(Application application);

        public ApplicationComponent applicationPasser();

    }

}
