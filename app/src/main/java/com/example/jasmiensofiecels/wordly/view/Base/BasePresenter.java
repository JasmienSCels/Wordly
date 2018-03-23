package com.example.jasmiensofiecels.wordly.view.Base;

import com.example.jasmiensofiecels.wordly.presenter.base.base.BaseService;
import com.example.jasmiensofiecels.wordly.presenter.base.base.BaseView;

/**
 * The purpose of this class is to have all other presenters inherit from this presenter.
 * It's main function is to handle the attachment and destruction of the view.
 *
 * Created by Jasmien Cels on 23/03/2018.
 */

public class BasePresenter<V extends BaseView> implements BaseService.BasePresenter<V> {


    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public V getView() {
        return view;
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }

}
