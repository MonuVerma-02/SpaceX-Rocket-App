package com.spacex.rockets.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.spacex.rockets.data.datasource.local.db.Converters
import com.spacex.rockets.data.datasource.local.db.SpacexDAO
import com.spacex.rockets.data.datasource.local.db.SpacexDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {
    @Singleton
    @Provides
    fun providesGson(): Gson {
        return Gson()
    }

    @Singleton
    @Provides
    fun providesDatabase(app: Application, gson: Gson): SpacexDatabase {
        return Room.databaseBuilder(app, SpacexDatabase::class.java, "spacex_database")
            .fallbackToDestructiveMigration()
            .addTypeConverter(Converters(gson))
            .build()
    }

    @Singleton
    @Provides
    fun providesDao(database: SpacexDatabase): SpacexDAO {
        return database.spaceXDao()
    }

}