package com.fritte.travelp.data.model.accuweather

import com.squareup.moshi.Json

data class AWCurrentConditions(
    @field:Json(name = "LocalObservationDateTime")
    val localObservationDateTime: String,
    @field:Json(name = "WeatherText")
    val weatherText: String,
    @field:Json(name = "WeatherIcon")
    val weatherIcon: Int,
    @field:Json(name = "HasPrecipitation")
    val hasPrecipitation: Boolean,
    @field:Json(name = "PrecipitationType")
    val precipitationType: String,
    @field:Json(name = "IsDayTime")
    val isDayTime: Boolean,
    @field:Json(name = "Temperature")
    val temperature: AWTemperature,
    @field:Json(name = "MobileLink")
    val mobileLink: String
)