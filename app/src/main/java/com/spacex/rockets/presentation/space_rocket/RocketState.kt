package com.spacex.rockets.presentation.space_rocket

import com.spacex.rockets.data.model.Rockets

data class RocketState(
    val rockets: Rockets? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)