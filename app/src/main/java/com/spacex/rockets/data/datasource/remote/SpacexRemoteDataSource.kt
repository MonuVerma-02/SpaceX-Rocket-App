package com.spacex.rockets.data.datasource.remote

import com.spacex.rockets.data.model.Rocket
import retrofit2.Response

interface SpacexRemoteDataSource {
    suspend fun getRockets(): Response<List<Rocket>>
}