package com.laksana.themovies

import android.view.View
import com.laksana.themovies.model.Movies

interface ClickCallback {
    fun onItemClicked(view: View, data: Movies)
}
