package com.renegens.finalappexample.topmovies;

import com.renegens.finalappexample.http.MovieService;
import com.renegens.finalappexample.http.apimodel.Result;
import com.renegens.finalappexample.http.apimodel.TopRated;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class TopMoviesRepository implements Repository {

    private MovieService movieService;
    private List<Result> results;
    private long timestamp;

    private static final long STALE_MS = 20 * 1000; // Data is stale after 20 seconds

    public TopMoviesRepository(MovieService movieService) {
        this.timestamp = System.currentTimeMillis();
        this.movieService = movieService;
        results = new ArrayList<>();

    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timestamp < STALE_MS;
    }

    @Override
    public Observable<Result> getResultsFromMemory() {

        if (isUpToDate()) {
            return Observable.from(results);
        } else {
            timestamp = System.currentTimeMillis();
            results.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<Result> getResultsFromNetwork() {

        Observable<TopRated> topRatedObservable = movieService.getTopRatedMovies(1).concatWith(movieService.getTopRatedMovies(2)).concatWith(movieService.getTopRatedMovies(3));

        return topRatedObservable.concatMap(new Func1<TopRated, Observable<Result>>() {
            @Override
            public Observable<Result> call(TopRated topRated) {
                return Observable.from(topRated.results);
            }
        }).doOnNext(new Action1<Result>() {
            @Override
            public void call(Result result) {
                results.add(result);
            }
        });
    }

    @Override
    public Observable<Result> getResultData() {
        return getResultsFromMemory().switchIfEmpty(getResultsFromNetwork());
    }
}
