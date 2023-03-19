package com.spacex.rockets.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Diameter(
    val feet: Double?,
    val meters: Double?
): Parcelable