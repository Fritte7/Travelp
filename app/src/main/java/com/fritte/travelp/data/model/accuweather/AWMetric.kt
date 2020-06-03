package com.fritte.travelp.data.model.accuweather

import com.squareup.moshi.Json

data class AWMetric(
    @field:Json(name = "Value")
    val value: Double,
    @field:Json(name = "Unit")
    val unit: String,
    @field:Json(name = "UnitType")
    val unitType: Int
)