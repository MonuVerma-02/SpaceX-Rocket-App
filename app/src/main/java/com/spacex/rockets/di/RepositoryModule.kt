package com.spacex.rockets.di

import com.spacex.rockets.data.repository.SpacexRepositoryImpl
import com.spacex.rockets.data.datasource.local.SpacexLocalDataSource
import com.spacex.rockets.data.datasource.remote.SpacexRemoteDataSource
import com.spacex.rockets.domain.repository.SpacexRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesRepository(
        remoteDataSource: SpacexRemoteDataSource,
        localDataSource: SpacexLocalDataSource
    ): SpacexRepository {
        return SpacexRepositoryImpl(remoteDataSource, localDataSource)
    }
}