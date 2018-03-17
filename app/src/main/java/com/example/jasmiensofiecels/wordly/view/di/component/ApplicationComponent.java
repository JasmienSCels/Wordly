package com.example.jasmiensofiecels.wordly.view.di.component;

import com.example.jasmiensofiecels.wordly.WordlyApplication;

import dagger.Component;
import dagger.android.AndroidInjector;

/**
 * The purpose of this interface is to represent the injector class.
 * It will build the component graph, which will provided injected instances through modules.
 *
 * Created by Jasmien Cels on 12/03/2018.
 */

@Component(modules = {})
public interface ApplicationComponent extends AndroidInjector<WordlyApplication> {

    //Bind instances to the component.
    @Component.Builder
    interface Builder {

    }

}
