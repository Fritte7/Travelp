package com.fritte.travelp.data.network

import com.fritte.travelp.data.model.accuweather.AWCurrentConditions
import com.fritte.travelp.data.model.accuweather.AWForecasts
import com.fritte.travelp.data.model.accuweather.AWLocation
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AccuWeatherAPI {

    companion object {
        const val API_KEY: String = "apikey"
        const val LOCATION_KEY: String = "locationkey"
        const val DETAILS: String = "details"
    }

    /** Returns information about a specific city, by GeoPosition (Latitude and Longitude) **/
    @GET("/locations/v1/cities/geoposition/search")
    suspend fun searchCityLoc(@Query(API_KEY) apiKey: String, @Query("q") latLng: String): Response<AWLocation>

    /** Returns information about the current condition, by location key **/
    @GET("/currentconditions/v1/{locationkey}")
    suspend fun getCurrentCondition(@Path(LOCATION_KEY) locationKey: String, @Query(API_KEY) apiKey: String, @Query(DETAILS) details: Boolean) : Response<List<AWCurrentConditions>>

    /** Returns forecast for the day, by location key **/
    @GET("/forecasts/v1/daily/1day/{locationkey}?metric=true")
    suspend fun getOneDayForecast(@Path(LOCATION_KEY) locationKey: String, @Query(API_KEY) apiKey: String, @Query(DETAILS) details: Boolean) : Response<AWForecasts>

    /** Returns forecast for five days, by location key **/
    @GET("/forecasts/v1/daily/5day/{locationkey}?metric=true")
    suspend fun getFiveDaysForecast(@Path(LOCATION_KEY) locationKey: String, @Query(API_KEY) apiKey: String, @Query(DETAILS) details: Boolean) : Response<AWForecasts>
}