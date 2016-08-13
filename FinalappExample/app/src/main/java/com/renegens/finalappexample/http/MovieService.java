package com.renegens.finalappexample.http;

import com.renegens.finalappexample.http.apimodel.TopRated;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface MovieService {

    @GET("top_rated")
    Observable<TopRated> getTopRatedMovies(@Query("page") Integer page);





}
