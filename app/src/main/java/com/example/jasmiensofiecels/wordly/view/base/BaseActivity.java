package com.example.jasmiensofiecels.wordly.view.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.example.jasmiensofiecels.wordly.R;
import com.example.jasmiensofiecels.wordly.di.component.component.ApplicationComponent;
import com.example.jasmiensofiecels.wordly.presenter.base.base.BaseView;

import javax.annotation.Nullable;
import javax.inject.Inject;

import dagger.android.AndroidInjection;

/*
 * The purpose of this class is to represent the underlying activity that all other activities will inherit from.
 *
 * Create by Jasmien Cels on 12/03/18
 */

public class BaseActivity extends AppCompatActivity implements BaseView {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void turnOnLoading() {

    }

    @Override
    public void turnOffLoading() {

    }

    @Override
    public void onError(@NonNull String err) {

    }
}
