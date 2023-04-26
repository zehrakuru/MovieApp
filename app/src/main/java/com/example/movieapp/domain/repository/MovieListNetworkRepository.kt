package com.example.movieapp.domain.repository

import com.example.movieapp.data.web.model.MovieListResponse

interface MovieListNetworkRepository {
    suspend fun getMovies(): MovieListResponse
}