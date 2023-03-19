package com.spacex.rockets.di

import com.spacex.rockets.data.datasource.remote.api.SpacexApiService
import com.spacex.rockets.data.datasource.local.db.SpacexDAO
import com.spacex.rockets.data.datasource.local.SpacexLocalDataSource
import com.spacex.rockets.data.datasource.remote.SpacexRemoteDataSource
import com.spacex.rockets.data.datasource.local.SpacexLocalDataSourceImpl
import com.spacex.rockets.data.datasource.remote.SpacexRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun providesLocalDataSource(spaceXDAO: SpacexDAO): SpacexLocalDataSource {
        return SpacexLocalDataSourceImpl(spaceXDAO)
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(spaceXApiService: SpacexApiService): SpacexRemoteDataSource {
        return SpacexRemoteDataSourceImpl(spaceXApiService)
    }
}