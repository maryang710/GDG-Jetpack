package com.maryang.jetpack.ui.base;

import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter implements LifecycleObserver {

    protected CompositeDisposable compositeDisposable;

    public BasePresenter() {
        compositeDisposable = new CompositeDisposable();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
        compositeDisposable.dispose();
    }
}