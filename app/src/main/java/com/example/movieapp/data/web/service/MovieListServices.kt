package com.example.movieapp.data.web.service

import com.example.movieapp.Utils.Constant
import com.example.movieapp.data.web.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieListServices {
    @GET("movie/popular")
    suspend fun getMovies(
        @Query("page")
        pageNumber: Int = 1,
        @Query("api_key")
        apiKey: String = Constant.API_KEY
    ): MovieListResponse
}