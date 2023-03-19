package com.spacex.rockets.presentation.space_rocket_details.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.spacex.rockets.databinding.DetailsImageSliderBinding

class SpaceRocketDetailsAdapter(
    private val context: Context,
    private val images: List<String>?,
) :
    RecyclerView.Adapter<SpaceRocketDetailsAdapter.ImageListViewHolder>() {

    class ImageListViewHolder(private val binding: DetailsImageSliderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(image: String?, context: Context) {
            Glide.with(context)
                .load(image)
                .into(binding.ivImages)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListViewHolder {
        val binding =
            DetailsImageSliderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageListViewHolder, position: Int) {
        val image = images?.get(position)
        holder.bind(image, context)
    }

    override fun getItemCount(): Int {
        return images?.size!!
    }

}



