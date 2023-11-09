package com.example.myhappyplants.di

import com.example.myhappyplants.network.PlantsInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideBaseURL(): String =
        "https://perenual.com/api/species-list/"

    @Provides
    @Singleton
    fun provideRetrofit(baseURL: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePlatsInterface(retrofit: Retrofit): PlantsInterface{
        return retrofit.create(PlantsInterface::class.java)
    }
}