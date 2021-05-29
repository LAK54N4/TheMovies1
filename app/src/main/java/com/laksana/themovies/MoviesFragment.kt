package com.laksana.themovies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.laksana.themovies.DetailsActivity.Companion.TYPE_MOVIES
import com.laksana.themovies.adapter.MoviesAdapter
import com.laksana.themovies.databinding.MoviesFragmentBinding
import com.laksana.themovies.model.Movies
import com.laksana.themovies.viewModel.MoviesViewModel

class MoviesFragment : Fragment(), ClickCallback {

    companion object {
        const val MOVIES = "movies"
        fun newInstance() = MoviesFragment()
    }

    private var viewBinding: MoviesFragmentBinding? = null
    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        viewBinding = MoviesFragmentBinding.inflate(inflater, container, false)
        return viewBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = MoviesFragmentBinding.bind(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            viewModel = ViewModelProvider(
                it, ViewModelProvider.NewInstanceFactory()
            )[MoviesViewModel::class.java]
        }
        val listMovie = viewModel.getListMovies()
        setRecyclerView(listMovie)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    private fun setRecyclerView(listMovie: List<Movies>) {
        viewBinding!!.recyclerViewMovies.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MoviesAdapter(this@MoviesFragment)
        }.also {
            it.adapter.let { adapter ->
                when(adapter) {
                    is MoviesAdapter -> {
                        adapter.setData(listMovie)
                    }
                }
            }
        }
    }

    override fun onItemClicked(view: View, data: Movies) {
        val moveViewDetail = Intent(context, DetailsActivity::class.java)
        moveViewDetail.putExtra(DetailsActivity.EXTRA_DATA, data.title)
        moveViewDetail.putExtra(DetailsActivity.EXTRA_TYPE, TYPE_MOVIES)
        startActivity(moveViewDetail)
    }
}