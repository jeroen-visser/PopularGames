package eu.jeroenvisser.populargames.data.remote.igdb

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GameDAO(
    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("name")
    @Expose
    var title: String,

    @SerializedName("cover")
    @Expose
    var cover: GameDaoCover,

    @SerializedName("rating")
    @Expose
    var rating: Double,

    @SerializedName("rating_count")
    @Expose
    var ratingCount: Int,

    @SerializedName("summary")
    @Expose
    var summary: String

)

data class GameDaoCover(

    @SerializedName("url")
    @Expose
    val url: String,

    @SerializedName("width")
    @Expose
    val width: Int,

    @SerializedName("height")
    @Expose
    val height: Int,
)