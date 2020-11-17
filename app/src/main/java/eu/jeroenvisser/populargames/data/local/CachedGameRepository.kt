package eu.jeroenvisser.populargames.data.local

import eu.jeroenvisser.populargames.data.local.entities.RoomGameEntity

interface CachedGameRepository {

    suspend fun insert(roomGameEntity: RoomGameEntity): Long

    suspend fun all(): List<RoomGameEntity>

}