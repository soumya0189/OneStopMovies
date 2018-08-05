package com.phoenixforcehq.onestopmovies.data.remote;


import com.phoenixforcehq.onestopmovies.model.MovieListResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import io.reactivex.Observable;

public interface Api {

    @GET("/3/movie/popular")
    Observable<MovieListResponse> getPopularMovies(
            @Query("api_key") String publicKey,
            @Query("language") String lang,
            @Query("page") int page);


}
