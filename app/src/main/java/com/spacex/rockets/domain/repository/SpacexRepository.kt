package com.spacex.rockets.domain.repository

import com.spacex.rockets.data.model.Rockets
import com.spacex.rockets.utils.Resource
import kotlinx.coroutines.flow.Flow

interface SpacexRepository {
    suspend fun getAllRockets(): Flow<Resource<Rockets>>
}