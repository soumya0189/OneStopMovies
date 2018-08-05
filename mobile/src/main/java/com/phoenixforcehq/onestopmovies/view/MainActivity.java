package com.phoenixforcehq.onestopmovies.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.phoenixforcehq.onestopmovies.OneStopMoviesApplication;
import com.phoenixforcehq.onestopmovies.R;
import com.phoenixforcehq.onestopmovies.data.remote.Api;
import com.phoenixforcehq.onestopmovies.model.MovieListResponse;
import com.phoenixforcehq.onestopmovies.presenter.PresenterMainActivity;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements BaseViewForMainActivity{

    @Inject
    public Api api;

    PresenterMainActivity presenter;

    @BindView(R.id.rv_now_playing)
    RecyclerView rvNowPlaying;

    @BindView(R.id.rv_popular)
    RecyclerView rvPopular;

    @BindView(R.id.rv_top_rated)
    RecyclerView rvTopRated;

    @BindView(R.id.rv_upcoming)
    RecyclerView rvUpcoming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OneStopMoviesApplication.getComponent().inject(this);

        // TODO Inject using Dagger 2
        presenter = new PresenterMainActivity(api);
        presenter.attach(this);
        presenter.getPopularMovies();

        setContentView(R.layout.activity_main_2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void load(MovieListResponse resp) {
        Log.d("TAG Movies", "size of list is"+resp.getMovies().size());
    }

    @Override
    public void error(Throwable e) {
        Log.e("TAG ERROR", e.getMessage());
    }
}
