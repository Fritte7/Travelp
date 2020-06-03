package com.fritte.travelp.data.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class NetworkAPI(private val _url: String) {

    /** return api for accuweather **/
    fun provideAccuWeatherAPI(): AccuWeatherAPI {
        return Retrofit.Builder()
            .baseUrl(_url)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(AccuWeatherAPI::class.java)
    }
}