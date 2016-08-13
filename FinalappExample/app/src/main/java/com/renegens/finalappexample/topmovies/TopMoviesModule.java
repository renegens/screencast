package com.renegens.finalappexample.topmovies;

import com.renegens.finalappexample.http.ApiModule;
import com.renegens.finalappexample.http.MovieService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ApiModule.class})

public class TopMoviesModule {

    @Provides
    public TopMoviesActivityMVP.Presenter provideTopMoviesActivityPresenter(TopMoviesActivityMVP.Model topMoviesModel) {
        return new TopMoviesPresenter(topMoviesModel);
    }

    @Provides
    public TopMoviesActivityMVP.Model provideTopMoviesActivityModel(Repository repository) {
        return new TopMoviesModel(repository);
    }

    @Singleton
    @Provides
    public Repository provideRepo(MovieService movieService) {
        return new TopMoviesRepository(movieService);
    }


}
