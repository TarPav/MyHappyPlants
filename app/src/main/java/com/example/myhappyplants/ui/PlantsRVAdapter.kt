package com.example.myhappyplants.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.myhappyplants.databinding.ItemPageLayoutBinding
import com.example.myhappyplants.domain.Plant
import com.example.myhappyplants.ui.PlantsRVAdapter.PlantsViewHolder

class PlantsRVAdapter(val context: Context) : RecyclerView.Adapter<PlantsViewHolder>() {
    inner class PlantsViewHolder(val binding: ItemPageLayoutBinding) :
        ViewHolder(binding.root) {
        fun bind(plant: Plant) {
            Glide.with(context)
                .load(plant.imageURL)
                .override(120, 120)
                .centerCrop()
                .transform(RoundedCorners(16))
                .into(binding.imagePlant)

            binding.commonNameTxt.text = plant.name
            binding.scientificNameTxt.text = plant.scientificName.first()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantsViewHolder {
        val binding = ItemPageLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return PlantsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: PlantsViewHolder, position: Int) {

        val item = differ.currentList[position]
        holder.bind(item)

    }

    private val differCallback = object : DiffUtil.ItemCallback<Plant>() {
        override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)


}
