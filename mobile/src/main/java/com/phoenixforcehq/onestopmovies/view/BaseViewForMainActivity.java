package com.phoenixforcehq.onestopmovies.view;

import com.phoenixforcehq.onestopmovies.model.MovieListResponse;

import java.util.List;

public interface BaseViewForMainActivity extends IView{
    public void load(MovieListResponse resp, int type);
}
