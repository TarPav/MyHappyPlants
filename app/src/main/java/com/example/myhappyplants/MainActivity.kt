package com.example.myhappyplants

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myhappyplants.domain.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.loadPlants(15, 1)

        setupObservers()

    }

    private fun setupObservers() {
        viewModel.plantsData.observe(this) { plantsList ->
            plantsList?.let {
                Log.d("TAG", "${it.toString()}")
            }

        }
    }
}