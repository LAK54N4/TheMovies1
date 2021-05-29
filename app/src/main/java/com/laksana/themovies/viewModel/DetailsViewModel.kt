package com.laksana.themovies.viewModel

import androidx.lifecycle.ViewModel
import com.laksana.themovies.model.Movies
import com.laksana.themovies.repository.ListMovies

class DetailsViewModel: ViewModel() {
    private lateinit var movie: String
    private lateinit var tvShow: String
    private lateinit var result : Movies

    private fun getListMovie(): ArrayList<Movies> {
        return ListMovies.listMovies() as ArrayList<Movies>
    }

    private fun getListTvShow(): ArrayList<Movies> {
        return ListMovies.listTvShows() as ArrayList<Movies>
    }

    fun setMovieTitle(movieTitle: String) {
        this.movie = movieTitle
    }

    fun setTvShowTitle(tvShowTitle: String) {
        this.tvShow = tvShowTitle
    }

    fun getDetailMovieTitle() : Movies {
        //var resultMovie = Movies("","","","","","","")
        val listMovie = getListMovie()
        for (i in listMovie) {
            if (i.title == movie) {
                result = i
                break
            }
        }
        return result
    }

    fun getDetailTvShowTitle(): Movies {
        //var resultTvShow: Movies = Movies("","","","","","","")
        val listTvShow = getListTvShow()
        for (i in listTvShow) {
            if (i.title == tvShow) {
                result = i
                break
            }
        }
        return result
    }
}