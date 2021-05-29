package com.laksana.themovies.viewModel

import androidx.lifecycle.ViewModel
import com.laksana.themovies.model.Movies
import com.laksana.themovies.repository.ListMovies

class MoviesViewModel : ViewModel() {
    fun getListMovies(): List<Movies> {
        return ListMovies.listMovies()
    }
}


