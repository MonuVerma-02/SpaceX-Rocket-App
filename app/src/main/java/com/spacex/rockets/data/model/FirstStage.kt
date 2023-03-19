package com.spacex.rockets.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FirstStage(
    val burn_time_sec: Int?,
    val engines: Int?,
    val fuel_amount_tons: Double?,
    val reusable: Boolean?,
    val thrust_sea_level: ThrustSeaLevel?,
    val thrust_vacuum: ThrustVacuum?
): Parcelable