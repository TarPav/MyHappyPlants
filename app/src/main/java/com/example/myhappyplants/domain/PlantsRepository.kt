package com.example.myhappyplants.domain

import com.example.myhappyplants.network.PlantAPIService
import javax.inject.Inject

class PlantsRepository @Inject constructor(private val apiInterface: PlantAPIService) {
    suspend fun getPlants(amount: Int, page: Int) = apiInterface.getPlants(amount, page)


}