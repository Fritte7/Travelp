package com.fritte.travelp.data.model.accuweather

import com.squareup.moshi.Json

data class AWLocation(
    @field:Json(name = "Key")
    val key: String,
    @field:Json(name = "EnglishName")
    val englishName: String,
    @field:Json(name = "Region")
    val region: AWRegion,
    @field:Json(name = "Country")
    val country: AWCountry,
    @field:Json(name = "TimeZone")
    val timeZone: AWTimeZone,
    @field:Json(name = "ParentCity")
    val parentCity: AWParentCity?
)

data class AWRegion(
    @field:Json(name = "EnglishName")
    val englishName: String
)

data class AWCountry(
    @field:Json(name = "EnglishName")
    val englishName: String
)

data class AWTimeZone(
    @field:Json(name = "GmtOffset")
    val gmtOffset: Float
)

data class AWParentCity(
    @field:Json(name = "Key")
    val key: String,
    @field:Json(name = "EnglishName")
    val englishName: String
)