package com.renegens.finalappexample.root;

import android.app.Application;

import com.renegens.finalappexample.http.ApiModule;
import com.renegens.finalappexample.topmovies.TopMoviesModule;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .apiModule(new ApiModule())
                .topMoviesModule(new TopMoviesModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
