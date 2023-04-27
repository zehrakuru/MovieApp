package com.example.movieapp.data.web.service

import com.example.movieapp.data.web.model.MovieDetailsResponse
import com.example.movieapp.utils.Constant
import com.example.movieapp.data.web.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieServices {
    @GET("movie/popular")
    suspend fun getMovies(
        @Query("page")
        pageNumber: Int = 1,
        @Query("api_key")
        apiKey: String = Constant.API_KEY
    ): MovieListResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id")
        id: String,
        @Query("api_key")
        apiKey: String = Constant.API_KEY
    ): MovieDetailsResponse
}