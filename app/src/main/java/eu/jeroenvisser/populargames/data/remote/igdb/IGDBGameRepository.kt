package eu.jeroenvisser.populargames.data.remote.igdb

import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST


interface IGDBGameRepository {

    enum class ImageSize { COVER, HD_READY }

    companion object {

        private const val IMAGE_URL = "https://images.igdb.com/igdb/image/upload/t_%size%_2x/%image_id%.jpg"

        fun urlForImageId(imageId: String, size: ImageSize = ImageSize.COVER) : String {
            return replaceImageSize(
                IMAGE_URL.replace("%image_id%", imageId),
                size
            )
        }

        private fun replaceImageSize(url: String, size: ImageSize): String {
            return when(size) {
                ImageSize.COVER -> url.replace("%size%", "cover_big")
                ImageSize.HD_READY -> url.replace("%size%", "720p")
            }
        }
    }

    @POST("games")
    suspend fun all(@Body requestBody: RequestBody): List<GameDAO>

}

fun allGamesRequestExample() : RequestBody {
    return RequestBody.create(
        MediaType.parse("text/plain"),
        "fields cover.url,cover.height,cover.width,cover.image_id,name,rating,rating_count,summary,storyline; sort rating_count desc; where rating > 75 & cover.url != null;"
    )
}