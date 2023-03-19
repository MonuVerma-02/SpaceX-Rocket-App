package com.spacex.rockets.presentation.space_rocket.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.spacex.rockets.data.model.Rocket
import com.spacex.rockets.data.model.Rockets
import com.spacex.rockets.databinding.SpacexRocketItemBinding

class SpaceRocketAdapter(
    private val context: Context,
    private var onItemClicked: (rocket: Rocket) -> Unit
) :
    RecyclerView.Adapter<SpaceRocketAdapter.TaskListViewHolder>() {

    private var rockets: Rockets? = null

    fun setTasksList(rockets: Rockets?) {
        this.rockets = rockets
    }

    class TaskListViewHolder(private val binding: SpacexRocketItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(rocketItem: Rocket?, context: Context, onItemClicked: (rocket: Rocket) -> Unit) {
            binding.textViewName.text = rocketItem?.name
            binding.textViewCountry.text = rocketItem?.country
            binding.textViewCount.text = "Engines: ${rocketItem?.engines?.number}"

            rocketItem?.flickr_images?.let {
                val viewPagerAdapter = ImageSlideAdapter(context, it)
                binding.viewpager.adapter = viewPagerAdapter
                binding.indicator.setViewPager(binding.viewpager)
            }

            binding.constraintLayoutMain.setOnClickListener {
                onItemClicked(rocketItem!!)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        val binding =
            SpacexRocketItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {
        val rocketItem = rockets?.rocketList?.get(position)
        holder.bind(rocketItem, context, onItemClicked)

    }

    override fun getItemCount(): Int {
        return rockets?.rocketList!!.size
    }

}



