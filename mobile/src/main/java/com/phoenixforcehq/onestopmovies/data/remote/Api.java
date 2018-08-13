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

    @GET("/3/movie/top_rated")
    Observable<MovieListResponse> getTopRatedMovies(
            @Query("api_key") String publicKey,
            @Query("language") String lang,
            @Query("page") int page);

    @GET("/3/movie/now_playing")
    Observable<MovieListResponse> getNowPlayingMovies(
            @Query("api_key") String publicKey,
            @Query("language") String lang,
            @Query("page") int page);

    @GET("/3/movie/upcoming")
    Observable<MovieListResponse> getUpcomingMovies(
            @Query("api_key") String publicKey,
            @Query("language") String lang,
            @Query("page") int page);


}
