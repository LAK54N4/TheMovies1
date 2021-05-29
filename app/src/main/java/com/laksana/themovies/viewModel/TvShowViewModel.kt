package com.laksana.themovies.viewModel

import androidx.lifecycle.ViewModel
import com.laksana.themovies.model.Movies
import com.laksana.themovies.repository.ListMovies

class TvShowViewModel : ViewModel() {
    fun getListTvShow(): List<Movies> {
        return ListMovies.listTvShows()
    }
}