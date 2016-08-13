package com.renegens.retrofitexample.http;

import com.renegens.retrofitexample.http.apimodel.Twitch;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TwitchAPI {

    @GET("games/top")
    Call <Twitch> getTopGames();





}
