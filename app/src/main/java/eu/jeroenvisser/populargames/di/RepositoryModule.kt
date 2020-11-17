package eu.jeroenvisser.populargames.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import eu.jeroenvisser.populargames.data.local.database.PopularGamesDao
import eu.jeroenvisser.populargames.data.local.mappers.LocalGameMapper
import eu.jeroenvisser.populargames.data.remote.igdb.IGDBGameRepository
import eu.jeroenvisser.populargames.data.remote.igdb.IGDBGameRepositoryMapper
import eu.jeroenvisser.populargames.data.repository.GameRepository
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideGameRepository(
        IGDBGameRepository: IGDBGameRepository,
        retrofitGameRepositoryMapper: IGDBGameRepositoryMapper,
        localGameMapper: LocalGameMapper,
        popularGamesDao: PopularGamesDao
    ) : GameRepository {
        return GameRepository(
            IGDBGameRepository,
            retrofitGameRepositoryMapper,
            localGameMapper,
            popularGamesDao
        )
    }

}