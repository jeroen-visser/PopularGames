package eu.jeroenvisser.populargames.data.remote.igdb

import retrofit2.http.Body
import retrofit2.http.POST

interface IGDBGameRepository {

    @POST("games")
    suspend fun all(@Body body: AllGamesRequest): List<GameDAO>

}

data class AllGamesRequest(
    var fields: String
)

fun allGamesRequestExample() : AllGamesRequest {
    return AllGamesRequest(
        "fields cover.url,cover.height,cover.width,name,rating,rating_count,summary; sort rating_count desc; where rating > 75 & cover.url != null;"
    )
}