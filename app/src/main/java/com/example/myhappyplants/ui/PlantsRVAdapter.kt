package com.example.myhappyplants.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.myhappyplants.databinding.MainScreenPageLayoutBinding
import com.example.myhappyplants.domain.Plant
import com.example.myhappyplants.ui.PlantsRVAdapter.PlantsViewHolder

class PlantsRVAdapter(val context: Context) : RecyclerView.Adapter<PlantsViewHolder>() {
    inner class PlantsViewHolder(val binding: MainScreenPageLayoutBinding) :
        ViewHolder(binding.root) {
        fun bind(model: Plant) {
            Glide.with(context)
                .load(model.imageURL)
                .into(binding.imagePlant)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantsViewHolder {
        val binding = MainScreenPageLayoutBinding
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
