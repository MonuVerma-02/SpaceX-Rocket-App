package com.spacex.rockets.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "rocket")
@Parcelize
data class Rocket(
    @PrimaryKey(autoGenerate = true)
    val _id: Int?,
    val active: Boolean?,
    val boosters: Int?,
    val company: String?,
    val cost_per_launch: Int?,
    val country: String?,
    val description: String?,
    val diameter: Diameter?,
    val engines: Engines?,
    val first_flight: String?,
    val first_stage: FirstStage?,
    val flickr_images: List<String>?,
    val height: Height?,
    val id: String?,
    val landing_legs: LandingLegs?,
    val mass: Mass?,
    val name: String?,
    val second_stage: SecondStage?,
    val stages: Int?,
    val success_rate_pct: Int?,
    val type: String?,
    val wikipedia: String?
): Parcelable