package com.example.jasmiensofiecels.wordly.di.component.module;

import com.example.jasmiensofiecels.wordly.view.base.BaseActivity;
import com.example.jasmiensofiecels.wordly.view.base.BaseModule;
import com.example.jasmiensofiecels.wordly.view.dailyWord.DailyWordActivity;
import com.example.jasmiensofiecels.wordly.view.dailyWord.DailyWordModule;

import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

/**
 * The purpose of this abstract class is to outline which modules are required for which activities.
 *
 * Created by Jasmien Cels on 17/03/2018.
 */

//Bindings to ensure the usability of the dagger framework.
@Module(includes = AndroidInjectionModule.class)
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {BaseModule.class})
    abstract BaseActivity contributeBaseActivityInjector();

    @ContributesAndroidInjector(modules = {DailyWordModule.class})
    abstract DailyWordActivity contributeDailyWordActivityInjector();

}
