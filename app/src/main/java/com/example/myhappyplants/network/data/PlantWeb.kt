package com.example.myhappyplants.network.data

import com.example.myhappyplants.domain.Plant
import com.google.gson.annotations.SerializedName

data class PlantWeb(
    @SerializedName("id") val id: Int,
    @SerializedName("common_name") val commonName: String,
    @SerializedName("scientific_name") val scientificName: List<String>,
    @SerializedName("cycle") val cycle: String,
    @SerializedName("watering") val watering: String,
    @SerializedName("default_image") val image: ImageWeb?
)



fun PlantWeb.toDomain() = Plant(id, commonName, scientificName,cycle,watering, image.toDomain())

