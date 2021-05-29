package com.laksana.themovies.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.laksana.themovies.MainActivity
import com.laksana.themovies.MoviesFragment
import com.laksana.themovies.TvShowFragment

class SectionsPagerAdapter(mainActivity: MainActivity) : FragmentStateAdapter(mainActivity) {

    companion object {
        const val NUM_PAGES = 2
    }

    override fun getItemCount(): Int {
        return NUM_PAGES
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MoviesFragment.newInstance()
            else -> TvShowFragment.newInstance()
        }
    }

}
