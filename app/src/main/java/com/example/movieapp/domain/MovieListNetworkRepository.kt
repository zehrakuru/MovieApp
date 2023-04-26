package com.example.movieapp.domain

import com.example.movieapp.data.web.model.MovieListResponse

interface MovieListNetworkRepository {
    suspend fun getMovies(): MovieListResponse
}