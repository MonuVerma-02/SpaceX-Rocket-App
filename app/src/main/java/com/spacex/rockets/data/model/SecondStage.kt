package com.spacex.rockets.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SecondStage(
    val burn_time_sec: Int?,
    val engines: Int?,
    val fuel_amount_tons: Double?,
    val payloads: Payloads?,
    val reusable: Boolean?,
    val thrust: Thrust?
): Parcelable