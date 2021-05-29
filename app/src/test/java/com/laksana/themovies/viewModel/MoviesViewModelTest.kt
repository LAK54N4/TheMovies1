package com.laksana.themovies.viewModel

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setUp() {
        viewModel = MoviesViewModel()
    }

    @Test
    fun getListMovies() {
        val movies = viewModel.getListMovies()
        assertNotNull(movies)
        assertEquals(10,movies.size)
    }
}