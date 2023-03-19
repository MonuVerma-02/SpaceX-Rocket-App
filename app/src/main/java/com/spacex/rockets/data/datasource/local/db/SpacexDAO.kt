package com.spacex.rockets.data.datasource.local.db

import androidx.room.*
import com.spacex.rockets.data.model.Rocket

@Dao
interface SpacexDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToRocket(rockets: List<Rocket>)

    @Query("select * from rocket")
    suspend fun getRocket() : List<Rocket>

    @Query("delete from rocket")
    suspend fun clearAll()

}