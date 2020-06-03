package com.fritte.travelp.data.model.accuweather

import com.squareup.moshi.Json

data class AWHeadline(
    @field:Json(name = "EffectiveDate")
    val effectiveDate: String,
    @field:Json(name = "Text")
    val text: String,
    @field:Json(name = "Category")
    val category: String,
    @field:Json(name = "EndDate")
    val endDate: String,
    @field:Json(name = "MobileLink")
    val mobileLink: String
)