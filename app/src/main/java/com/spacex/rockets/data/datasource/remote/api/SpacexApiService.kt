package com.spacex.rockets.data.datasource.remote.api

import com.spacex.rockets.data.model.Rocket
import retrofit2.Response
import retrofit2.http.GET

interface SpacexApiService {

    @GET("/v4/rockets")
    suspend fun getRockets(): Response<List<Rocket>>
}