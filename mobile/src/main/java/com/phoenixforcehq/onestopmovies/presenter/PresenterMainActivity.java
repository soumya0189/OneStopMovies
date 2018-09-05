package com.phoenixforcehq.onestopmovies.presenter;

import android.util.Log;

import com.phoenixforcehq.onestopmovies.data.remote.Api;
import com.phoenixforcehq.onestopmovies.view.BaseViewForMainActivity;

import io.reactivex.Scheduler;

public class PresenterMainActivity extends BasePresenter<BaseViewForMainActivity> {
    Api api;
    Scheduler scheduler;
    Scheduler androidScheduler;

    public PresenterMainActivity(Api api, Scheduler scheduler, Scheduler androidScheduler) {
        if(this.api == null && this.androidScheduler==null && this.scheduler==null){
            this.api = api;
            this.scheduler = scheduler;
            this.androidScheduler = androidScheduler;
        }
    }

    public void getPopularMovies() {
        if(scheduler==null){
            Log.d("TAG", "@@");
        }
        compositeDisposable.add(api.getPopularMovies("3a13589c7f664a40de2c9663d8bd6c9e","en-US",1)
                .subscribeOn(scheduler)
                .observeOn(androidScheduler)
                .subscribe(movieListResponse -> view.load(movieListResponse,0),
                        throwable -> view.error(throwable)));

    }

    public void getTopRatedMovies(){
        compositeDisposable.add(api.getTopRatedMovies("3a13589c7f664a40de2c9663d8bd6c9e","en-US",1)
                .subscribeOn(scheduler)
                .observeOn(androidScheduler)
                .subscribe(movieListResponse -> view.load(movieListResponse, 1),
                        throwable -> view.error(throwable)));
    }

    public void getNowPlayingMovies(){
        compositeDisposable.add(api.getNowPlayingMovies("3a13589c7f664a40de2c9663d8bd6c9e","en-US",1)
                .subscribeOn(scheduler)
                .observeOn(androidScheduler)
                .subscribe(movieListResponse -> view.load(movieListResponse, 2),
                        throwable -> view.error(throwable)));
    }

    public void getUpcomingMovies(){
        compositeDisposable.add(api.getUpcomingMovies("3a13589c7f664a40de2c9663d8bd6c9e","en-US",1)
                .subscribeOn(scheduler)
                .observeOn(androidScheduler)
                .subscribe(movieListResponse -> view.load(movieListResponse, 3),
                        throwable -> view.error(throwable)));
    }
}
