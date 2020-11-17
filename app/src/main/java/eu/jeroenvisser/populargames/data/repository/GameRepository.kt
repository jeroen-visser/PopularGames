package eu.jeroenvisser.populargames.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import eu.jeroenvisser.populargames.data.entities.Game
import eu.jeroenvisser.populargames.data.local.database.PopularGamesDao
import eu.jeroenvisser.populargames.data.local.mappers.LocalGameMapper
import eu.jeroenvisser.populargames.data.remote.igdb.IGDBGameRepository
import eu.jeroenvisser.populargames.data.remote.igdb.IGDBGameRepositoryMapper
import eu.jeroenvisser.populargames.data.remote.igdb.allGamesRequestExample

class GameRepository constructor(
    private val gameRepository: IGDBGameRepository,
    private val retrofitGameRepositoryMapper: IGDBGameRepositoryMapper,
    private val localGameMapper: LocalGameMapper,
    private val popularGamesDao: PopularGamesDao
) {
    suspend fun loadGames() {
        val gamesDao = gameRepository.all(allGamesRequestExample())
            val networkGames = retrofitGameRepositoryMapper.fromListOfDao(gamesDao)
            networkGames
                .map { localGameMapper.toEntity(it) }
                .forEach { popularGamesDao.insert(it) }
    }

    fun getGames() : LiveData<List<Game>> {
        return popularGamesDao.all().map {
            it.map {
                localGameMapper.toDomain(it)
            }
        }
    }
}