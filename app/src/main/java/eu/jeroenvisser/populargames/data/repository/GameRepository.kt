package eu.jeroenvisser.populargames.data.repository

import eu.jeroenvisser.populargames.data.entities.Game
import eu.jeroenvisser.populargames.data.local.CachedGameRepository
import eu.jeroenvisser.populargames.data.local.mappers.LocalGameMapper
import eu.jeroenvisser.populargames.data.remote.igdb.IGDBGameRepository
import eu.jeroenvisser.populargames.data.remote.igdb.IGDBGameRepositoryMapper
import eu.jeroenvisser.populargames.data.remote.igdb.allGamesRequestExample

class GameRepository constructor(
    private val gameRepository: IGDBGameRepository,
    private val retrofitGameRepositoryMapper: IGDBGameRepositoryMapper,
    private val cachedGameRepository: CachedGameRepository,
    private val localGameMapper: LocalGameMapper
) {
    suspend fun games(forceRefresh: Boolean = false): List<Game> {

        try {

            if (forceRefresh || cachedGameRepository.all().isEmpty()) {
                val gamesDao = gameRepository.all(allGamesRequestExample())
                val networkGames = retrofitGameRepositoryMapper.fromListOfDao(gamesDao)
                networkGames
                    .map { localGameMapper.toEntity(it) }
                    .forEach { cachedGameRepository.insert(it) }
            }

        } catch (e: Exception) {}

        return try {
            cachedGameRepository.all().map { localGameMapper.toDomain(it) }
        } catch (e: Exception) {
            ArrayList<Game>()
        }
    }
}