package com.spacex.rockets.data.datasource.local

import com.spacex.rockets.data.model.Rocket

interface SpacexLocalDataSource {
    suspend fun addToRocket(rocket: List<Rocket>)
    suspend fun getRockets(): List<Rocket>
    suspend fun clear()
}