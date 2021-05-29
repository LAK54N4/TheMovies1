package com.laksana.themovies

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.laksana.themovies.adapter.TvShowsAdapter
import com.laksana.themovies.databinding.TvShowFragmentBinding
import com.laksana.themovies.model.Movies
import com.laksana.themovies.viewModel.TvShowViewModel

class TvShowFragment : Fragment() {

    companion object {
        fun newInstance() = TvShowFragment()
    }

    private lateinit var viewModel: TvShowViewModel
    private var viewBinding: TvShowFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = TvShowFragmentBinding.inflate(inflater, container, false)
        return  viewBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = TvShowFragmentBinding.bind(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            viewModel = ViewModelProvider(it,
                ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]
        }
        val listTvShow = viewModel.getListTvShow()
        setRecyclerView(listTvShow)
    }

    private fun setRecyclerView(listTvShow: List<Movies>) {
        viewBinding!!.recyclerViewTvShows.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TvShowsAdapter(this@TvShowFragment)
        }.also {
            it.adapter.let { adapter ->
                when(adapter) {
                    is TvShowsAdapter -> {
                        adapter.setData(listTvShow)
                    }
                }
            }
        }
    }

    fun onItemClicked(data: Movies) {
        val moveViewDetail = Intent(context, DetailsActivity::class.java)
        moveViewDetail.putExtra(DetailsActivity.EXTRA_DATA, data.title)
        moveViewDetail.putExtra(DetailsActivity.EXTRA_TYPE, DetailsActivity.TYPE_TVSHOW)
        startActivity(moveViewDetail)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewBinding = null
    }
}