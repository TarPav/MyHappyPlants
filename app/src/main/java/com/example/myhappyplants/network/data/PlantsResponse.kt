package com.example.myhappyplants.network.data

import com.google.gson.annotations.SerializedName

data class PlantsResponse(@SerializedName("data") val plants: List<PlantWeb>)
fun PlantsResponse.toDomain() = plants.map(PlantWeb::toDomain)