package com.spacex.rockets.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.spacex.rockets.databinding.SpacexRocketActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpacexRocketActivity : AppCompatActivity() {

    private lateinit var binding: SpacexRocketActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SpacexRocketActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}