package com.example.movieapp.data.web.repository

import com.example.movieapp.data.web.model.MovieDetailsResponse
import com.example.movieapp.data.web.service.MovieServices
import com.example.movieapp.domain.repository.MovieDetailsNetworkRepository
import javax.inject.Inject

class MovieDetailsNetworkRepositoryImpl @Inject constructor (
    private val movieDetailsServices : MovieServices
        ) : MovieDetailsNetworkRepository {

    //this is implemented by override
    override suspend fun getMovieDetails(movie_id : String): MovieDetailsResponse {
        return movieDetailsServices.getMovieDetails(movie_id)
    }

}