package com.example.pp.api.datamodels


import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("Response")
    val response: String = "",
    @SerializedName("Search")
    val search: List<Search> = listOf(),
    @SerializedName("totalResults")
    val totalResults: String = ""
)