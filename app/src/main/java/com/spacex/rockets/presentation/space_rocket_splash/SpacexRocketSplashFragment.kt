package com.spacex.rockets.presentation.space_rocket_splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.spacex.rockets.R

import com.spacex.rockets.databinding.SpacexRocketSplashBinding
import com.spacex.rockets.utils.Constants
import kotlinx.coroutines.delay

class SpacexRocketSplashFragment : Fragment() {
    private lateinit var binding: SpacexRocketSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SpacexRocketSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialiseUiView()
        initialiseSplashScreen()
    }

    private fun initialiseUiView() {
        binding.circleImageView.animation = AnimationUtils.loadAnimation(activity, R.anim.fade_in)
        binding.textAppName.animation = AnimationUtils.loadAnimation(activity, R.anim.slide_in_left)
        binding.textApp.animation = AnimationUtils.loadAnimation(activity, R.anim.slide_in_right)
    }

    private fun initialiseSplashScreen() {
        lifecycleScope.launchWhenStarted {
            delay(Constants.SPLASH_SCREEN_TIMEOUT)
            val action =
                SpacexRocketSplashFragmentDirections.actionSpacexRocketSplashToSpacexRocket()
            findNavController().navigate(action)
        }
    }
}