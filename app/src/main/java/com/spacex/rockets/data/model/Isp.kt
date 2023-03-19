package com.spacex.rockets.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Isp(
    val sea_level: Int?,
    val vacuum: Int?
): Parcelable