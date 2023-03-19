package com.spacex.rockets.data.datasource.local

import com.spacex.rockets.data.datasource.local.db.SpacexDAO
import com.spacex.rockets.data.model.Rocket
import javax.inject.Inject

class SpacexLocalDataSourceImpl @Inject constructor(
    private val dao: SpacexDAO
) : SpacexLocalDataSource {

    override suspend fun addToRocket(rockets: List<Rocket>) {
        return dao.addToRocket(rockets)
    }

    override suspend fun getRockets(): List<Rocket> {
        return dao.getRocket()
    }

    override suspend fun clear() {
        return dao.clearAll()
    }

}