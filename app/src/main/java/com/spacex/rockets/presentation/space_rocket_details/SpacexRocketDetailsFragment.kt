package com.spacex.rockets.presentation.space_rocket_details

import android.os.Bundle
import android.text.util.Linkify
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.spacex.rockets.R
import com.spacex.rockets.databinding.SpacexRocketDetailsBinding
import com.spacex.rockets.presentation.space_rocket_details.adapter.SpaceRocketDetailsAdapter
import com.spacex.rockets.utils.popBack
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpacexRocketDetailsFragment : Fragment() {

    private var _binding: SpacexRocketDetailsBinding? = null

    private val binding get() = _binding!!

    private val args: SpacexRocketDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = SpacexRocketDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialiseUiView()
        initialiseListener()
    }

    private fun initialiseUiView() {
        binding.customToolbar.toolbarTitle.text = args.rocket.name
        binding.tvDescription.text = args.rocket.description
        binding.tvStatus.text =
            if (args.rocket.active == true) getString(R.string.active) else getString(R.string.inactive)
        binding.tvCost.text = args.rocket.cost_per_launch.toString()
        binding.tvHeight.text =
            "${args.rocket.height?.meters.toString()} mt,".plus("${args.rocket.height?.feet.toString()} ft")
        binding.tvDiameter.text =
            "${args.rocket.diameter?.meters.toString()} mt,".plus("${args.rocket.diameter?.meters.toString()} ft")
        binding.tvWikipediaLink.text = args.rocket.wikipedia
        Linkify.addLinks(binding.tvWikipediaLink, Linkify.WEB_URLS)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = SpaceRocketDetailsAdapter(context, args.rocket.flickr_images)
        }
    }

    private fun initialiseListener() {
        binding.customToolbar.toolbarBackImage.setOnClickListener {
            findNavController().popBack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}