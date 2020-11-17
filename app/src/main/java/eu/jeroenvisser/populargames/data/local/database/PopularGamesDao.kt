package eu.jeroenvisser.populargames.data.local.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import eu.jeroenvisser.populargames.data.local.entities.RoomGameEntity

@Dao
interface PopularGamesDao {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insert(roomGameEntity: RoomGameEntity): Long

        @Query("SELECT * FROM games")
        fun all(): LiveData<List<RoomGameEntity>>

}