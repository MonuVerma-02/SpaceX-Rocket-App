package com.spacex.rockets.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CompositeFairing(
    val diameter: Diameter?,
    val height: Height?
): Parcelable