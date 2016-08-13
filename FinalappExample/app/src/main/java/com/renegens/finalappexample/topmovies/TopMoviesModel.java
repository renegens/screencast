package com.renegens.finalappexample.topmovies;

import com.renegens.finalappexample.http.apimodel.Result;

import rx.Observable;
import rx.functions.Func1;

public class TopMoviesModel implements TopMoviesActivityMVP.Model {

    private Repository repository;

    public TopMoviesModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<ViewModel> result() {

        return repository.getResultData().flatMap(new Func1<Result, Observable<ViewModel>>() {
            @Override
            public Observable<ViewModel> call(Result result) {
                return Observable.just(new ViewModel(result.title));
            }
        });
    }

}
