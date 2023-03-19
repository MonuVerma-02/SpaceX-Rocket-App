package com.spacex.rockets.data.datasource.local.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.spacex.rockets.data.model.*
import javax.inject.Inject

@ProvidedTypeConverter
class Converters @Inject constructor(
    private val gson: Gson
) {
    @TypeConverter
    fun fromThrustSeaLevel(thrustSeaLevel: ThrustSeaLevel): String {
        return gson.toJson(thrustSeaLevel)
    }

    @TypeConverter
    fun toThrustSeaLevel(json: String): ThrustSeaLevel {
        val type = object : TypeToken<ThrustSeaLevel>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromThrustVacuum(thrustVacuum: ThrustVacuum): String {
        return gson.toJson(thrustVacuum)
    }

    @TypeConverter
    fun toThrustVacuum(json: String): ThrustVacuum {
        val type = object : TypeToken<ThrustVacuum>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromEngines(engines: Engines): String {
        return gson.toJson(engines)
    }

    @TypeConverter
    fun toEngines(json: String): Engines {
        val type = object : TypeToken<Engines>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromFirstStage(firstStage: FirstStage): String {
        return gson.toJson(firstStage)
    }

    @TypeConverter
    fun toFirstStage(json: String): FirstStage {
        val type = object : TypeToken<FirstStage>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromLandingLegs(landingLegs: LandingLegs): String {
        return gson.toJson(landingLegs)
    }

    @TypeConverter
    fun toLandingLegs(json: String): LandingLegs {
        val type = object : TypeToken<LandingLegs>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromMass(mass: Mass): String {
        return gson.toJson(mass)
    }

    @TypeConverter
    fun toMass(json: String): Mass {
        val type = object : TypeToken<Mass>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromSecondStage(secondStage: SecondStage): String {
        return gson.toJson(secondStage)
    }

    @TypeConverter
    fun toSecondStage(json: String): SecondStage {
        val type = object : TypeToken<SecondStage>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromHeight(height: Height): String {
        return gson.toJson(height)
    }

    @TypeConverter
    fun toHeight(json: String): Height {
        val type = object : TypeToken<Height>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromPayloads(payloads: Payloads): String {
        return gson.toJson(payloads)
    }

    @TypeConverter
    fun toPayloads(json: String): Payloads {
        val type = object : TypeToken<Payloads>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromThrust(thrust: Thrust): String {
        return gson.toJson(thrust)
    }

    @TypeConverter
    fun toThrust(json: String): Thrust {
        val type = object : TypeToken<Thrust>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromDiameter(diameter: Diameter): String {
        return gson.toJson(diameter)
    }

    @TypeConverter
    fun toDiameter(json: String): Diameter {
        val type = object : TypeToken<Diameter>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun toListOfStrings(value: String): List<String> {
        val listType = object : TypeToken<List<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromListOfStrings(list: List<String>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}