package com.example.myhappyplants.network

import com.example.myhappyplants.network.data.PlantsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PlantAPIService {
    @GET("species-list")
    suspend fun getPlants(
        @Query("page") page: Number,
        @Query("key") key: String = "sk-qci6651db408ab8c92344"
        ): Response<PlantsResponse>
}