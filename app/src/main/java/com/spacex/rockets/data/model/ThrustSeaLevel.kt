package com.spacex.rockets.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ThrustSeaLevel(
    val kN: Int?,
    val lbf: Int?
): Parcelable