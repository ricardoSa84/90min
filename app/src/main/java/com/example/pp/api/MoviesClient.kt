package com.example.pp.api

import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class MoviesClient {
    fun getClient(): MoviesInterface {

        var retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.omdbapi.com/?&apiKey=b847bca0&s=avengers")
            .build().apply {

            }

        return retrofit.create(MoviesInterface::class.java)
    }
}