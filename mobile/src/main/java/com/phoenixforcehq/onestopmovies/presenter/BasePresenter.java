package com.phoenixforcehq.onestopmovies.presenter;

import com.phoenixforcehq.onestopmovies.view.IView;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<T extends IView>  {

    CompositeDisposable compositeDisposable;
    T view;

    public BasePresenter() {
        compositeDisposable = new CompositeDisposable();
    }

    public void attach(T view) {
        this.view = view;
    }

    public void detach() {
        view = null;
    }

    public void clearSubscriptions() {
        compositeDisposable.clear();
    }
}
