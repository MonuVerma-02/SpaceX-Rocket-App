package com.spacex.rockets.di

import com.spacex.rockets.domain.use_case.GetRocketsUseCase
import com.spacex.rockets.presentation.space_rocket.SpaceXRocketViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ViewModelModule {

    @Singleton
    @Provides
    fun providesSpaceXRocketViewModel(rocketsUseCase: GetRocketsUseCase): SpaceXRocketViewModel {
        return SpaceXRocketViewModel(rocketsUseCase)
    }
}