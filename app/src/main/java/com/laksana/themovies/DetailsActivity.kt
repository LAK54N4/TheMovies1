package com.laksana.themovies

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.laksana.themovies.databinding.ActivityDetailsBinding
import com.laksana.themovies.model.Movies
import com.laksana.themovies.viewModel.DetailsViewModel
import java.util.*

class DetailsActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "extra_type"
        const val TYPE_MOVIES = "type_movies"
        const val TYPE_TVSHOW = "type_tvshow"
    }

    private lateinit var detailBinding: ActivityDetailsBinding
    private lateinit var result: Movies

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        val toolbar = detailBinding.detailToolbar
        setSupportActionBar(toolbar)
        Objects.requireNonNull(supportActionBar!!).setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this,
                ViewModelProvider.NewInstanceFactory())[DetailsViewModel::class.java]

        val data = intent.getStringExtra(EXTRA_DATA)
        val type = intent.getStringExtra(EXTRA_TYPE)

        if (type.equals(TYPE_MOVIES, ignoreCase = true)) {
                data?.let {
                  showToolbarTitle(it)
                  viewModel.setMovieTitle(it)
            }
            result = viewModel.getDetailMovieTitle()
        }

        else if (type.equals(TYPE_TVSHOW, ignoreCase = true)) {
            data?.let {
                showToolbarTitle(it)
                viewModel.setTvShowTitle(it)
            }
            result = viewModel.getDetailTvShowTitle()
        }

        setImage(result.imgBackground, detailBinding.imgBackground)
        setImage(result.poster, detailBinding.imgDetailPoster)
        detailBinding.tvTitle.text = result.title
        detailBinding.tvOverviewValue.text = result.desc
        detailBinding.tvReleaseDateValue.text = result.release
        detailBinding.tvGenreValue.text = result.genre
        detailBinding.tvActorName.text = result.actor
    }

    private fun setImage(poster: String, imgDetailPoster: ImageView) {
        Glide.with(this).load(poster)
                .placeholder(R.drawable.ic_baseline_movie_24)
                .error(R.drawable.ic_baseline_error_24)
                .into(imgDetailPoster)
    }

    private fun showToolbarTitle(title: String) {
        val collapsingToolbar : CollapsingToolbarLayout = detailBinding.collapsingToolbar
        collapsingToolbar.title = title
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val i = Intent(this@DetailsActivity, MainActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        finish()
    }
}