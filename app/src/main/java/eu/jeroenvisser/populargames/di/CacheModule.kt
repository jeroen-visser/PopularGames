package eu.jeroenvisser.populargames.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import eu.jeroenvisser.populargames.data.entities.Game
import eu.jeroenvisser.populargames.data.local.database.PopularGamesDao
import eu.jeroenvisser.populargames.data.local.database.PopularGamesDatabase
import eu.jeroenvisser.populargames.data.local.entities.RoomGameEntity
import eu.jeroenvisser.populargames.data.local.mappers.LocalGameMapper
import eu.jeroenvisser.populargames.utils.EntityMapper
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideLocalGameMapper(): EntityMapper<RoomGameEntity, Game> {
        return LocalGameMapper()
    }

    @Singleton
    @Provides
    fun providePopularGamesDatabase(@ApplicationContext context: Context): PopularGamesDatabase {
        return Room
            .databaseBuilder(
                context,
                PopularGamesDatabase::class.java,
                PopularGamesDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providePopularGamesDao(popularGamesDatabase: PopularGamesDatabase): PopularGamesDao {
        return popularGamesDatabase.popularGamesDao()
    }

}