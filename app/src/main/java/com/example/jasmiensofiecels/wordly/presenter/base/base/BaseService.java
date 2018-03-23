package com.example.jasmiensofiecels.wordly.presenter.base.base;

/**
 * The purpose of this interface is to impose methods that the Base presenter must implement.
 *
 * Created by Jasmien Cels on 23/03/2018.
 */

public interface BaseService {

    interface BasePresenter<V extends BaseView> {

        void attachView(V view);

        V getView();

        void onDestroy();
    }
}
