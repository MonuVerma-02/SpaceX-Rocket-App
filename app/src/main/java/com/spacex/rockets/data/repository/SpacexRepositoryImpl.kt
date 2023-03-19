package com.spacex.rockets.data.repository

import com.spacex.rockets.data.model.Rockets
import com.spacex.rockets.data.datasource.local.SpacexLocalDataSource
import com.spacex.rockets.data.datasource.remote.SpacexRemoteDataSource
import com.spacex.rockets.domain.repository.SpacexRepository
import com.spacex.rockets.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.net.UnknownHostException
import javax.inject.Inject

class SpacexRepositoryImpl @Inject constructor(
    private val remoteDataSource: SpacexRemoteDataSource,
    private val localDataSource: SpacexLocalDataSource
) : SpacexRepository {

    override suspend fun getAllRockets(): Flow<Resource<Rockets>> = flow {
        emit(Resource.Loading())

        val rockets = localDataSource.getRockets()
        emit(Resource.Loading(data = Rockets(rockets)))

        try {
            val response = remoteDataSource.getRockets()
            response.body()?.let { result ->
                localDataSource.clear()
                localDataSource.addToRocket(result)
            }
        } catch (e: UnknownHostException) {
            val newRockets = localDataSource.getRockets()
            if (newRockets.isEmpty()) {
                emit(
                    Resource.Error(
                        message = "No Internet Connection for Load data",
                    )
                )
            }
        } catch (e: Exception) {
            emit(
                Resource.Error(
                    message = "Something went wrong ${e.message}",
                    data = Rockets(rockets)
                )
            )
        }
        val newRockets = localDataSource.getRockets()
        emit(Resource.Success(Rockets(newRockets)))
    }

}