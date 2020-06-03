package com.fritte.travelp.data.model.accuweather

import com.squareup.moshi.Json

data class AWDailyForecast(
    @field:Json(name = "Date")
    val date: String,
    @field:Json(name = "Temperature")
    val temperature: AWTemperature,
    @field:Json(name = "Day")
    val day: AWDayNight,
    @field:Json(name = "Night")
    val night: AWDayNight,
    @field:Json(name = "MobileLink")
    val mobileLink: String
)