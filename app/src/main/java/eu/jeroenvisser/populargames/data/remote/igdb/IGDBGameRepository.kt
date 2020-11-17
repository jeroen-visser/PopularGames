package eu.jeroenvisser.populargames.data.remote.igdb

import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface IGDBGameRepository {

    @POST("games")
    suspend fun all(@Body requestBody: RequestBody): List<GameDAO>

}

fun allGamesRequestExample() : RequestBody {
    return RequestBody.create(
        MediaType.parse("text/plain"),
        "fields cover.url,cover.height,cover.width,name,rating,rating_count,summary; sort rating_count desc; where rating > 75 & cover.url != null;"
    )
}