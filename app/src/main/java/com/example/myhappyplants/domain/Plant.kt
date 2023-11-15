package com.example.myhappyplants.domain

data class Plant(
    val id: Int,
    val name: String,
    val scientificName: List<String>,
    val cycle: String,
    val watering: String,
    val imageURL: String
)