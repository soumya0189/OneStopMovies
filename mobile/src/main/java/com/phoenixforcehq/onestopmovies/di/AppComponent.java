package com.phoenixforcehq.onestopmovies.di;

import com.phoenixforcehq.onestopmovies.data.remote.ApiModule;
import com.phoenixforcehq.onestopmovies.presenter.PresenterMainActivity;
import com.phoenixforcehq.onestopmovies.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {
    void inject(MainActivity activity);

    void inject(PresenterMainActivity activity);
}
