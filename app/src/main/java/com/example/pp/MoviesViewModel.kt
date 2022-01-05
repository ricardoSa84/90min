package com.example.pp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pp.api.datamodels.Search
import com.example.pp.repositorys.MoviesRepository
import kotlinx.coroutines.launch

class MoviesViewModel(private val moviesRepository: MoviesRepository) : ViewModel() {
    var moviesList = MutableLiveData<List<Search>>()
    private val apiKey = "b847bca0"
    private val search = "avengers"
    fun getMovies() {
        viewModelScope.launch {
            moviesList.value = moviesRepository.getMoviesList(apiKey, search)
        }
    }
}