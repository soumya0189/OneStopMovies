package com.phoenixforcehq.onestopmovies;


import com.phoenixforcehq.onestopmovies.data.remote.Api;
import com.phoenixforcehq.onestopmovies.data.remote.ApiModule;
import com.phoenixforcehq.onestopmovies.model.Movie;
import com.phoenixforcehq.onestopmovies.model.MovieListResponse;
import com.phoenixforcehq.onestopmovies.presenter.PresenterMainActivity;
import com.phoenixforcehq.onestopmovies.view.MainActivity;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import org.junit.Assert.*;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class PresenterMainActivtyTest {

    @Mock
    Api api;
    @Mock
    MainActivity mainActivity;

    MovieListResponse resp;
    PresenterMainActivity mainPresenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        setMockData();
        mainPresenter = new PresenterMainActivity(api, Schedulers.computation(), Schedulers.computation());
    }

    @Test
    public void getPopularMovies_test(){
        when(api.getPopularMovies("3a13589c7f664a40de2c9663d8bd6c9e","en-US",1))
                .thenReturn(Observable.just(resp));

        mainPresenter.getPopularMovies();
        //testScheduler.triggerActions();

        InOrder inOrder = Mockito.inOrder(mainActivity);
        inOrder.verify(mainActivity, times(1)).load(resp, 0);
    }

    @Test
    public void getTopRatedMovies_test(){
        when(api.getTopRatedMovies("3a13589c7f664a40de2c9663d8bd6c9e","en-US",1))
                .thenReturn(Observable.just(resp));

        mainPresenter.getTopRatedMovies();
        //testScheduler.triggerActions();

        InOrder inOrder = Mockito.inOrder(mainActivity);
        inOrder.verify(mainActivity, times(1)).load(resp, 0);
    }

    @Test
    public void getNowPlayingMovies_test(){
        when(api.getNowPlayingMovies("3a13589c7f664a40de2c9663d8bd6c9e","en-US",1))
                .thenReturn(Observable.just(resp));

        mainPresenter.getNowPlayingMovies();
        //testScheduler.triggerActions();

        InOrder inOrder = Mockito.inOrder(mainActivity);
        inOrder.verify(mainActivity, times(1)).load(resp, 0);
    }

    @Test
    public void getUpcomingMovies_test(){
        when(api.getUpcomingMovies("3a13589c7f664a40de2c9663d8bd6c9e","en-US",1))
                .thenReturn(Observable.just(resp));

        mainPresenter.getUpcomingMovies();
        //testScheduler.triggerActions();

        InOrder inOrder = Mockito.inOrder(mainActivity);
        inOrder.verify(mainActivity, times(1)).load(resp, 0);

    }

    void setMockData(){
        Movie movie1 = new Movie("Movie 1");
        Movie movie2 = new Movie("Movie 2");
        Movie movie3 = new Movie("Movie 3");

        List<Movie> list = new ArrayList<>();
        list.add(movie1);
        list.add(movie2);
        list.add(movie3);

        resp = new MovieListResponse();
        resp.setMovies(list);
        resp.setPage(0);
        resp.setTotalPages(12);
        resp.setTotalResults(240);

    }
}
