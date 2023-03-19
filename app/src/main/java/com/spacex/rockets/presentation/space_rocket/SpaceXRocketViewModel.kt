package com.spacex.rockets.presentation.space_rocket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spacex.rockets.domain.use_case.GetRocketsUseCase
import com.spacex.rockets.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpaceXRocketViewModel @Inject constructor(
    private val getRocketsUseCase: GetRocketsUseCase,
) : ViewModel() {

    private val _rocketsState = MutableLiveData(RocketState())
    val rocketsState: LiveData<RocketState> = _rocketsState

    init {
        getAllRockets()
    }

    fun onFragmentReadyToView() {
        if (rocketsState.value?.rockets?.rocketList?.isNullOrEmpty() == true) {
            getAllRockets()
        }
    }

    fun getAllRockets() {
        viewModelScope.launch {
            getRocketsUseCase.invoke().collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        _rocketsState.value = rocketsState.value?.copy(
                            isLoading = true,
                        )
                    }
                    is Resource.Success -> {
                        _rocketsState.value = result.data?.let {
                            rocketsState.value?.copy(
                                rockets = it,
                                isLoading = false,
                            )
                        }
                    }
                    is Resource.Error -> {
                        _rocketsState.value = rocketsState.value?.copy(
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            }
        }
    }
}