package com.phoenixforcehq.onestopmovies;

import android.app.Application;

import com.phoenixforcehq.onestopmovies.data.remote.ApiModule;
import com.phoenixforcehq.onestopmovies.di.AppComponent;
import com.phoenixforcehq.onestopmovies.di.AppModule;
import com.phoenixforcehq.onestopmovies.di.DaggerAppComponent;

public class OneStopMoviesApplication extends Application{

    private static AppComponent component;

    @Override public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule())
                .build();
    }

    public static AppComponent getComponent() {
        return component;
    }
}
