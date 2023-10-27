package com.example.myhappyplants.network

import com.example.myhappyplants.data.PlantsModel
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlantsInterface {
    @GET(".")
    fun getPlants(
        @Query("limit") amount: Int,
        //The number page you want to see
        @Query("page") page: Int,
        //A secret/unique number to gain access
        @Query("api_key") key: String = "sk-qci6651db408ab8c92344",

//        //A string/query consisting of keywords that are used to search for names of species
//        @Query("q") q: String,
//        //A secret/unique number to gain access
//        @Query("api_key") key: String = "sk-qci6651db408ab8c92344",
//        //Alphabetical order species common name
//        @Query("order") order: String,
//        //If plant species is edible or not for consumption
//        @Query("edible") edible: Boolean,
//        //If plant species is poisonous or not
//        @Query("poisonous") poisonous: Boolean,
//        //The plant cycle of the species
//        @Query("cycle") cycle: String,
//        //The watering amount of the species
//        @Query("watering") watering: String,
//        //The sunlight amount of the species
//        @Query("sunlight") sunlight: String,
//        //If plant species is indoors
//        @Query("indoor") indoor: Boolean,
//
//        //Plant Details
//        //ID of plant species
//        @Query("ID") id: Int


    ): Call<List<PlantsModel>?>
}