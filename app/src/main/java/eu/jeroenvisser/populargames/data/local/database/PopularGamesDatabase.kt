package eu.jeroenvisser.populargames.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import eu.jeroenvisser.populargames.data.local.entities.RoomGameEntity

@Database(entities = [RoomGameEntity::class ], version = 3, exportSchema = false)
abstract class PopularGamesDatabase: RoomDatabase() {

    abstract fun popularGamesDao(): PopularGamesDao

    companion object{
        val DATABASE_NAME: String = "popular_games_db"
    }


}