package com.spacex.rockets.data.datasource.remote

import com.spacex.rockets.data.datasource.remote.api.SpacexApiService
import com.spacex.rockets.data.model.Rocket
import retrofit2.Response
import javax.inject.Inject

class SpacexRemoteDataSourceImpl @Inject constructor(
    private val apiService: SpacexApiService
) : SpacexRemoteDataSource {

    override suspend fun getRockets(): Response<List<Rocket>> {
        return apiService.getRockets()
    }
}