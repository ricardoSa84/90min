package com.example.pp.api

import com.example.pp.api.datamodels.Search
import retrofit2.await

class MoviesApi(private val client: MoviesClient) {
    suspend fun getMovies(apiKey:String,search:String): List<Search> {
            return client.getClient().getMovies(apiKey,search).await().search
    }
}