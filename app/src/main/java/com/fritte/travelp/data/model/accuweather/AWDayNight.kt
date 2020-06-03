package com.fritte.travelp.data.model.accuweather

import com.squareup.moshi.Json

data class AWDayNight(
    @field:Json(name = "Icon")
    val icon: Int,
    @field:Json(name = "IconPhrase")
    val iconPhrase: String,
    @field:Json(name = "HasPrecipitation")
    val hasPrecipitation: Boolean
)