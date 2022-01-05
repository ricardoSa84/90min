package com.example.pp.repositorys

import com.example.pp.api.MoviesApi
import com.example.pp.api.datamodels.Search

class MoviesRepository(private val moviesApi:MoviesApi) {
    suspend  fun getMoviesList(apiKey:String,search:String): List<Search> {
        return moviesApi.getMovies(apiKey,search)
    }
}