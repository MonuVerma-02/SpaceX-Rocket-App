package com.spacex.rockets.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mass(
    val kg: Int?,
    val lb: Int?
): Parcelable