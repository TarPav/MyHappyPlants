package com.example.myhappyplants.domain

import com.example.myhappyplants.network.PlantAPIService
import com.example.myhappyplants.network.data.toDomain
import javax.inject.Inject

class PlantsRepository @Inject constructor(private val apiInterface: PlantAPIService) {
    suspend fun getPlants(page: Int) = apiInterface.getPlants(page).body()?.toDomain()
}