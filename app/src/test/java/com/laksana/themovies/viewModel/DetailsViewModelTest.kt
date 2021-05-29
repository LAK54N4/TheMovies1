package com.laksana.themovies.viewModel

import com.laksana.themovies.repository.ListMovies
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailsViewModelTest {

    private lateinit var viewModel: DetailsViewModel
    private val dataMovie = ListMovies.listMovies()[0]
    private val dataTvShow = ListMovies.listTvShows()[0]
    private val movieTitle = dataMovie.title
    private val tvShowTitle = dataTvShow.title

    @Before
    fun setUp() {
        viewModel = DetailsViewModel()
        viewModel.setMovieTitle(movieTitle)
        viewModel.setTvShowTitle(tvShowTitle)
    }

    @Test
    fun getDetailMovieTitle() {
        val movie = viewModel.getDetailMovieTitle()
        assertNotNull(movie)
        assertEquals(dataMovie.title, movie.title)
        assertEquals(dataMovie.desc, movie.desc)
        assertEquals(dataMovie.poster, movie.poster)
        assertEquals(dataMovie.release, movie.release)
        assertEquals(dataMovie.actor, movie.actor)
        assertEquals(dataMovie.genre, movie.genre)
        assertEquals(dataMovie.imgBackground, movie.imgBackground)
    }

    @Test
    fun getDetailTvShowTitle() {
        val movie = viewModel.getDetailTvShowTitle()
        assertNotNull(movie)
        assertEquals(dataTvShow.title, movie.title)
        assertEquals(dataTvShow.desc, movie.desc)
        assertEquals(dataTvShow.poster, movie.poster)
        assertEquals(dataTvShow.release, movie.release)
        assertEquals(dataTvShow.actor, movie.actor)
        assertEquals(dataTvShow.genre, movie.genre)
        assertEquals(dataTvShow.imgBackground, movie.imgBackground)
    }
}