package com.laksana.themovies.model

import android.os.Parcelable
//import kotlinx.android.parcel.Parcelize
import kotlinx.parcelize.Parcelize

//import androidx.versionedparcelable.VersionedParcelize
//import android.os.Parcelable
//import kotlinx.android.parcel.Parcelize
//

@Parcelize
data class Movies (
    var title: String,
    var desc: String,
    var poster: String,
    var release: String,
    var genre: String,
    var actor: String,
    var imgBackground: String

) : Parcelable

