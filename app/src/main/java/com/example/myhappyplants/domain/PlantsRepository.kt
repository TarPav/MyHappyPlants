package com.example.myhappyplants.domain

import com.example.myhappyplants.network.PlantsInterface
import javax.inject.Inject

class PlantsRepository @Inject constructor(private val apiInterface: PlantsInterface) {
    suspend fun getPlants(amount: Int, page: Int) = apiInterface.getPlants(amount, page)


}