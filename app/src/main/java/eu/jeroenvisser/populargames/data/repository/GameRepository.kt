package eu.jeroenvisser.populargames.data.repository

import eu.jeroenvisser.populargames.data.entities.Game
import eu.jeroenvisser.populargames.data.remote.igdb.IGDBGameRepository
import eu.jeroenvisser.populargames.data.remote.igdb.IGDBGameRepositoryMapper
import eu.jeroenvisser.populargames.data.remote.igdb.allGamesRequestExample

class GameRepository constructor(
    private val IGDBGameRepository: IGDBGameRepository,
    private val retrofitGameRepositoryMapper: IGDBGameRepositoryMapper
) {
    suspend fun games(): List<Game> {

        return try {
            val gamesDao = IGDBGameRepository.all(allGamesRequestExample())
            retrofitGameRepositoryMapper.fromListOfDao(gamesDao)
        } catch (e: Exception) {
            ArrayList<Game>()
        }

    }
}