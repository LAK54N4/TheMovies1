package com.laksana.themovies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.laksana.themovies.ClickCallback
import com.laksana.themovies.R
import com.laksana.themovies.databinding.ItemMoviesBinding
import com.laksana.themovies.model.Movies

class MoviesAdapter(private var callback: ClickCallback) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>(){

    private var moviesItem: ArrayList<Movies> = ArrayList()

    fun setData(data: List<Movies>) {
        moviesItem.clear()
        moviesItem.addAll(data)
    }

    inner class ViewHolder(private val binding: ItemMoviesBinding): RecyclerView.ViewHolder (binding.root) {
        fun bind(movies: Movies) {
            Glide.with(itemView.context).load(movies.poster)
                .placeholder(R.drawable.ic_baseline_movie_24)
                .error(R.drawable.ic_baseline_error_24)
                .into(binding.poster)

            binding.tvTitle.text = movies.title
            binding.tvRelease.text = movies.release
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesAdapter.ViewHolder, position: Int) {
        val movie = moviesItem[position]
        holder.bind(movie)

        holder.itemView.setOnClickListener {
            callback.onItemClicked(it, moviesItem[position])
        }
    }

    override fun getItemCount(): Int {
        return moviesItem.size
    }

}
