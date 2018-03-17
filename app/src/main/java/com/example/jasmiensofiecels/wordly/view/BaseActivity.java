package com.example.jasmiensofiecels.wordly.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jasmiensofiecels.wordly.R;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import dagger.android.AndroidInjection;
import dagger.android.DaggerActivity;

/*
 * The purpose of this class is to represent the underlying activity that all other activities will inherit from.
 *
 * Create by Jasmien Cels on 12/03/18
 */

public class BaseActivity extends DaggerActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);


    }
}
