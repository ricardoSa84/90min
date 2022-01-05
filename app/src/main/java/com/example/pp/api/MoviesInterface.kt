package com.example.pp.api

import com.example.pp.api.datamodels.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesInterface {
    @GET("/")
    fun getMovies(@Query("apiKey") key: String, @Query("s") search: String): Call<MoviesResponse>
}
