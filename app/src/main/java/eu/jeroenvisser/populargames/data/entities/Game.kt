package eu.jeroenvisser.populargames.data.entities

data class Game(
    var id: Int,
    var title: String,
    var cover: Cover,
    var description: String,
    var rating: Double,
    var ratingCount: Int
)

data class Cover(
    var url: String,
    var width: Int,
    var height: Int
)