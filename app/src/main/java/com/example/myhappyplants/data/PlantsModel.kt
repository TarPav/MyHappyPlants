package com.example.myhappyplants.data

import com.google.gson.annotations.SerializedName

data class PlantsModel(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("common_name") var commonName: String? = null,
    @SerializedName("scientific_name") var scientificName: ArrayList<String> = arrayListOf(),
    @SerializedName("other_name") var otherName: ArrayList<String> = arrayListOf(),
    @SerializedName("cycle") var cycle: String? = null,
    @SerializedName("watering") var watering: String? = null,
    @SerializedName("sunlight") var sunlight: ArrayList<String> = arrayListOf(),
    @SerializedName("small_url") var smallUrl: String? = null,
//    @SerializedName("default_image") var defaultImage: DefaultImage? = DefaultImage()

//    @SerializedName("data") var data: ArrayList<Data> = arrayListOf(),
//    @SerializedName("to") var to: Int? = null,
//    @SerializedName("per_page") var perPage: Int? = null,
//    @SerializedName("current_page") var currentPage: Int? = null,
//    @SerializedName("from") var from: Int? = null,
//    @SerializedName("last_page") var lastPage: Int? = null,
//    @SerializedName("total") var total: Int? = null

)

//data class DefaultImage(
//
//    @SerializedName("license") var license: Int? = null,
//    @SerializedName("license_name") var licenseName: String? = null,
//    @SerializedName("license_url") var licenseUrl: String? = null,
//    @SerializedName("original_url") var originalUrl: String? = null,
//    @SerializedName("regular_url") var regularUrl: String? = null,
//    @SerializedName("medium_url") var mediumUrl: String? = null,
//      @SerializedName("small_url") var smallUrl: String? = null,
//    @SerializedName("thumbnail") var thumbnail: String? = null

//)

//data class Data(
//
//    @SerializedName("id") var id: Int? = null,
//    @SerializedName("common_name") var commonName: String? = null,
//    @SerializedName("scientific_name") var scientificName: ArrayList<String> = arrayListOf(),
//    @SerializedName("other_name") var otherName: ArrayList<String> = arrayListOf(),
//    @SerializedName("cycle") var cycle: String? = null,
//    @SerializedName("watering") var watering: String? = null,
//    @SerializedName("sunlight") var sunlight: ArrayList<String> = arrayListOf(),
//    @SerializedName("default_image") var defaultImage: DefaultImage? = DefaultImage()

//)
