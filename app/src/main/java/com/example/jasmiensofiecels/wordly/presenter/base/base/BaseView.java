package com.example.jasmiensofiecels.wordly.presenter.base.base;

import android.support.annotation.NonNull;

import javax.annotation.Nullable;

/**
 * The purpose of this interface is to represent the core functionality that all views must implement.
 * Created by jcels on 23/03/2018.
 */

public interface BaseView {

    boolean isNetworkConnected();

    void turnOnLoading();

    void turnOffLoading();

    void onError(@NonNull String err);

}
