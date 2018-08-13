package com.phoenixforcehq.onestopmovies.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.phoenixforcehq.onestopmovies.OneStopMoviesApplication;
import com.phoenixforcehq.onestopmovies.R;
import com.phoenixforcehq.onestopmovies.data.remote.Api;
import com.phoenixforcehq.onestopmovies.model.MovieListResponse;
import com.phoenixforcehq.onestopmovies.presenter.PresenterMainActivity;
import com.phoenixforcehq.onestopmovies.view.adapters.MoviesAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements BaseViewForMainActivity{

    @Inject
    public Api api;

    PresenterMainActivity presenter;

    @Nullable
    @BindView(R.id.rv_now_playing)
    RecyclerView rvNowPlaying;

    @Nullable
    @BindView(R.id.rv_popular)
    RecyclerView rvPopular;

    @Nullable
    @BindView(R.id.rv_top_rated)
    RecyclerView rvTopRated;

    @Nullable
    @BindView(R.id.rv_upcoming)
    RecyclerView rvUpcoming;

    MoviesAdapter adapterForPopularMovies;
    MoviesAdapter adapterForTopRatedMovies;
    MoviesAdapter adapterForNowPlayingMovies;
    MoviesAdapter adapterForUpcomingMovies;

    private Unbinder unbinder;

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
        ButterKnife.bind(this);

        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        adapterForPopularMovies = new MoviesAdapter(this);
        rvPopular.setAdapter(adapterForPopularMovies);
        rvPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapterForTopRatedMovies = new MoviesAdapter(this);
        rvTopRated.setAdapter(adapterForTopRatedMovies);
        rvTopRated.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapterForNowPlayingMovies = new MoviesAdapter(this);
        rvNowPlaying.setAdapter(adapterForNowPlayingMovies);
        rvNowPlaying.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapterForUpcomingMovies = new MoviesAdapter(this);
        rvUpcoming.setAdapter(adapterForUpcomingMovies);
        rvUpcoming.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //unbinder.unbind();
    }

    @Override
    public void load(MovieListResponse resp, int listType) {
        Log.d("TAG Movies", "size of list is"+resp.getMovies().size());
        switch (listType){
            case 0:
                adapterForPopularMovies.setMoviesList(resp.getMovies());
                break;
            case 1:
                adapterForTopRatedMovies.setMoviesList(resp.getMovies());
                break;
            case 2:
                adapterForNowPlayingMovies.setMoviesList(resp.getMovies());
                break;
            case 3:
                adapterForUpcomingMovies.setMoviesList(resp.getMovies());
                break;
        }
    }

    @Override
    public void error(Throwable e) {
        Log.e("TAG ERROR", e.getMessage());
    }
}
