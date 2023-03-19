package com.spacex.rockets.domain.use_case

import com.spacex.rockets.data.model.Rockets
import com.spacex.rockets.domain.repository.SpacexRepository
import com.spacex.rockets.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRocketsUseCase @Inject constructor(
    private val repository: SpacexRepository
) {
    suspend operator fun invoke(): Flow<Resource<Rockets>> {
        return repository.getAllRockets()
    }
}