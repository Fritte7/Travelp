package com.fritte.travelp.data.model.accuweather

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "forecasts_table")
data class AWForecasts(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "key")
    @field:Json(name = "Key")
    val key: String,

    @field:Json(name = "Headline")
    val headline: AWHeadline,
    @field:Json(name = "DailyForecasts")
    val dailyForecasts: AWDailyForecast
)