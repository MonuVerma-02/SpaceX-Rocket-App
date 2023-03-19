package com.spacex.rockets.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Thrust(
    val kN: Int?,
    val lbf: Int?
): Parcelable