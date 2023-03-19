package com.spacex.rockets.data.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.spacex.rockets.data.model.Rocket

@Database(entities = [Rocket::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class SpacexDatabase : RoomDatabase(){

    abstract fun spaceXDao() : SpacexDAO
}