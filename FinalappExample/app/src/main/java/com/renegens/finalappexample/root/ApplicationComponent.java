package com.renegens.finalappexample.root;

import com.renegens.finalappexample.http.ApiModule;
import com.renegens.finalappexample.topmovies.TopMoviesActivity;
import com.renegens.finalappexample.topmovies.TopMoviesModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class, TopMoviesModule.class})
public interface ApplicationComponent {

    void inject(TopMoviesActivity target);

}
