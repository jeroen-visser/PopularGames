package eu.jeroenvisser.populargames.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import eu.jeroenvisser.populargames.data.repository.GameRepository
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRepository() = GameRepository()

}