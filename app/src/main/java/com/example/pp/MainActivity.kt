package com.example.pp

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.pp.api.MoviesApi
import com.example.pp.api.MoviesClient
import com.example.pp.databinding.ActivityMainBinding
import com.example.pp.repositorys.MoviesRepository

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private val viewModel by lazy {
        MoviesViewModel(MoviesRepository(MoviesApi(MoviesClient())))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val adapter = MoviesAdapter()

        binding.recycler.adapter = adapter

        viewModel.moviesList.observe(this) {
            adapter.setData(it)
        }

        viewModel.getMovies()
    }

}