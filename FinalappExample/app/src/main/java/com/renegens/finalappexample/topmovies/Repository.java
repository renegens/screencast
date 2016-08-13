package com.renegens.finalappexample.topmovies;

import com.renegens.finalappexample.http.apimodel.Result;

import rx.Observable;


public interface Repository {

    Observable<Result> getResultsFromMemory();

    Observable<Result> getResultsFromNetwork();

    Observable<Result> getResultData();

}
