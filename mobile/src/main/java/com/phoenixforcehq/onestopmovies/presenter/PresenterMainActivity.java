package com.phoenixforcehq.onestopmovies.presenter;

import com.phoenixforcehq.onestopmovies.data.remote.Api;
import com.phoenixforcehq.onestopmovies.view.BaseViewForMainActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PresenterMainActivity extends BasePresenter<BaseViewForMainActivity> {
    private Api api;

    public PresenterMainActivity(Api api) {
        this.api = api;
    }

    public void getPopularMovies() {
        compositeDisposable.add(api.getPopularMovies("3a13589c7f664a40de2c9663d8bd6c9e","en-US",1)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movieListResponse -> view.load(movieListResponse,0),
                        throwable -> view.error(throwable)));

        compositeDisposable.add(api.getTopRatedMovies("3a13589c7f664a40de2c9663d8bd6c9e","en-US",1)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movieListResponse -> view.load(movieListResponse, 1),
                        throwable -> view.error(throwable)));

        compositeDisposable.add(api.getNowPlayingMovies("3a13589c7f664a40de2c9663d8bd6c9e","en-US",1)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movieListResponse -> view.load(movieListResponse, 2),
                        throwable -> view.error(throwable)));

        compositeDisposable.add(api.getUpcomingMovies("3a13589c7f664a40de2c9663d8bd6c9e","en-US",1)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movieListResponse -> view.load(movieListResponse, 3),
                        throwable -> view.error(throwable)));
    }
}
