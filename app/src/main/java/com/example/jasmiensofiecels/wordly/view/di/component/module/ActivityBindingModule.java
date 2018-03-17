package com.example.jasmiensofiecels.wordly.view.di.component.module;

import dagger.Module;
import dagger.android.AndroidInjectionModule;

/**
 * The purpose of this abstract class is to outline which modules are required for which activities.
 *
 * Created by Jasmien Cels on 17/03/2018.
 */

//Bindings to ensure the usability of the dagger framework.
@Module(includes = AndroidInjectionModule.class)
public abstract class ActivityBindingModule {



}
