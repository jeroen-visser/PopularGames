package eu.jeroenvisser.populargames.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class RoomGameEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "summary")
    var summary: String,

    @ColumnInfo(name = "storyLine")
    var storyLine: String,

    @ColumnInfo(name = "coverId")
    var coverId: String,

    @ColumnInfo(name = "coverUrl")
    var coverUrl: String,

    @ColumnInfo(name = "coverWidth")
    var coverWidth: Int,

    @ColumnInfo(name = "coverHeight")
    var coverHeight: Int,

    @ColumnInfo(name = "rating")
    var rating: Double,

    @ColumnInfo(name = "ratingCount")
    var ratingCount: Int,
)