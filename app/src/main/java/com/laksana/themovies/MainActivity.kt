package com.laksana.themovies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.laksana.themovies.adapter.SectionsPagerAdapter
import com.laksana.themovies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var viewPager2: ViewPager2
    private lateinit var pagerAdapter: FragmentStateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        showTabs()
        showMovies()
        showTvShow()
    }

    private fun showTvShow() {
        val fragmentTvShows: TvShowFragment = TvShowFragment.newInstance()
        val bundle = Bundle()
        bundle.putString(MoviesFragment.MOVIES, "")
        fragmentTvShows.arguments = bundle
    }

    private fun showMovies() {
        val fragmentMovies: MoviesFragment = MoviesFragment.newInstance()
        val bundle = Bundle()
        bundle.putString(MoviesFragment.MOVIES, "movies")
        fragmentMovies.arguments = bundle
    }

    private fun showTabs() {
        viewPager2 = activityMainBinding.viewpager
        pagerAdapter = SectionsPagerAdapter(this)
        viewPager2.adapter = pagerAdapter

        TabLayoutMediator(activityMainBinding.tabs, viewPager2) { tab, position ->
            tab.text = when(position) {
                0 -> resources.getString(R.string.movies)
                else -> resources.getString(R.string.tv_shows)
            }
        }.attach()
    }
}