package eu.jeroenvisser.populargames.data.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Game(
    var id: Int,
    var title: String,
    var summary: String,
    var storyLine: String,
    var cover: Cover,
    var rating: Double,
    var ratingCount: Int
) : Parcelable

@Parcelize
data class Cover(
    var id: String,
    var url: String,
    var width: Int,
    var height: Int
) : Parcelable