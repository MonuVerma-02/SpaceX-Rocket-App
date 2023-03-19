package com.spacex.rockets.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ThrustVacuum(
    val kN: Int?,
    val lbf: Int?
) : Parcelable