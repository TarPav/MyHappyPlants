package com.example.myhappyplants.network.data

import com.example.myhappyplants.domain.Plant
import com.google.gson.annotations.SerializedName

data class PlantWeb(
    @SerializedName("id") val id: Int,
    @SerializedName("common_name") val commonName: String,
    @SerializedName("default_image") val image: ImageWeb?

)

fun PlantWeb.toDomain() = Plant(id, commonName, image.toDomain())