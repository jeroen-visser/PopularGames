package eu.jeroenvisser.populargames.data.local

import eu.jeroenvisser.populargames.data.local.database.PopularGamesDao
import eu.jeroenvisser.populargames.data.local.entities.RoomGameEntity

class RoomCachedGameRepository constructor(
    private val popularGamesDao: PopularGamesDao
) : CachedGameRepository {

    override suspend fun insert(roomGameEntity: RoomGameEntity): Long {
        return popularGamesDao.insert(roomGameEntity)
    }

    override suspend fun all(): List<RoomGameEntity> {
        return popularGamesDao.all()
    }
}