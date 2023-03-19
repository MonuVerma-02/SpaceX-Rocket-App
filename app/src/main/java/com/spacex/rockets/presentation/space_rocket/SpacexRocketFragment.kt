package com.spacex.rockets.presentation.space_rocket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.spacex.rockets.data.model.Rocket
import com.spacex.rockets.data.model.Rockets
import com.spacex.rockets.databinding.SpacexRocketsBinding
import com.spacex.rockets.presentation.space_rocket.adapter.SpaceRocketAdapter
import com.spacex.rockets.utils.checkConnect
import com.spacex.rockets.utils.hideProgressBar
import com.spacex.rockets.utils.showProgressBar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SpacexRocketFragment : Fragment() {

    private var _binding: SpacexRocketsBinding? = null
    private val binding get() = _binding!!

    private var spacexAdapter: SpaceRocketAdapter? = null

    @Inject
    lateinit var viewModel: SpaceXRocketViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SpacexRocketsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialiseObservers()
        initialiseCollectors()
    }

    private fun initialiseObservers() {
        viewModel.rocketsState.observe(viewLifecycleOwner) { rocketState ->
            if (rocketState.isLoading) {
                activity?.showProgressBar()
            } else {
                hideProgressBar()
                if (rocketState?.rockets?.rocketList?.isNotEmpty() == true) {
                    bindAdapter(rocketState.rockets)
                } else {
                    Snackbar.make(
                        binding.root,
                        "${rocketState.error}",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun initialiseCollectors() {
        lifecycleScope.launchWhenStarted {
            activity?.checkConnect()?.collect { isAvailable ->
                if (isAvailable) {
                    viewModel.onFragmentReadyToView()
                }
            }
        }
    }

    private fun bindAdapter(rockets: Rockets) {
        spacexAdapter = SpaceRocketAdapter(requireActivity()) { rocket ->
            onItemClick(rocket)
        }

        if (binding.recyclerView?.adapter != null) {
            binding.recyclerView?.adapter?.notifyDataSetChanged()
        } else {
            binding.recyclerView?.adapter = spacexAdapter
            spacexAdapter?.setTasksList(rockets)
        }
    }

    private fun onItemClick(rocket: Rocket) {
        val action = SpacexRocketFragmentDirections.actionSpacexRocketToSpacexRocketDetails(rocket)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}