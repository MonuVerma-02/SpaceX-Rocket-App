package com.spacex.rockets.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Payloads(
    val composite_fairing: CompositeFairing?,
    val option_1: String?
): Parcelable