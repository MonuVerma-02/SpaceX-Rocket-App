package com.spacex.rockets.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LandingLegs(
    val material: String?,
    val number: Int?
) : Parcelable