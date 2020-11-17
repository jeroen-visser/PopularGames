package eu.jeroenvisser.populargames.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import eu.jeroenvisser.populargames.data.local.CachedGameRepository
import eu.jeroenvisser.populargames.data.local.RoomCachedGameRepository
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
        cachedGameRepository: CachedGameRepository,
        localGameMapper: LocalGameMapper
    ) : GameRepository {
        return GameRepository(
            IGDBGameRepository,
            retrofitGameRepositoryMapper,
            cachedGameRepository,
            localGameMapper
        )
    }

}