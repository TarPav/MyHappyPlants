package com.example.myhappyplants

import android.os.Build.VERSION_CODES.P
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myhappyplants.databinding.MainScreenPageBinding
import com.example.myhappyplants.domain.MainActivityViewModel
import com.example.myhappyplants.ui.PlantsRVAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var binding: MainScreenPageBinding
    private lateinit var plantsAdapter: PlantsRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainScreenPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.loadPlants(15, 1)

        setupViews()
        setupObservers()
    }

    private fun setupViews() {

        plantsAdapter = PlantsRVAdapter( this)

        with(binding.recyclerPlantsList) {
            binding.recyclerPlantsList.layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = plantsAdapter
        }
    }

    private fun setupObservers() {
        viewModel.plantsData.observe(this) { plantsList ->
            plantsList?.let { plants ->
                plantsAdapter.differ.submitList(plants)
            }
        }
        viewModel.loadingState.observe(this) { isLoading ->
            if (isLoading) {
                binding.mainScreenPageProgressBar.visibility = View.VISIBLE
            } else {
                binding.mainScreenPageProgressBar.visibility = View.INVISIBLE
            }
        }
    }
}