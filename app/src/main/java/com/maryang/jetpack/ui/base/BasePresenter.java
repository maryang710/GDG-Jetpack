package com.maryang.jetpack.ui.base;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter {

    protected CompositeDisposable compositeDisposable;

    public BasePresenter() {
        compositeDisposable = new CompositeDisposable();
    }

    public void onDestroy() {
        compositeDisposable.dispose();
    }
}