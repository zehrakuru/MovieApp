package com.example.movieapp.domain.repository

import com.example.movieapp.data.web.model.MovieDetailsResponse

interface MovieDetailsNetworkRepository {
    suspend fun getMovieDetails(movie_id:String) : MovieDetailsResponse
}