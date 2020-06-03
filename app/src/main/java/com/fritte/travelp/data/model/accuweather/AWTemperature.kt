package com.fritte.travelp.data.model.accuweather

import com.squareup.moshi.Json

data class AWTemperature(
    @field:Json(name = "Metric")
    val metric: AWMetric,
    @field:Json(name = "Minimum")
    val minimum: AWMetric,
    @field:Json(name = "Maximum")
    val maximum: AWMetric
)