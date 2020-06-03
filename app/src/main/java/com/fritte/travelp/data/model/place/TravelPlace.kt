package com.fritte.travelp.data.model.place

import androidx.room.*

@Entity(tableName = "travel_place_table")
data class TravelPlace(
    @ColumnInfo(name = "city")
    var city: String? = null
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null

    @ColumnInfo(name = "place_id")
    var placeID: String? = ""

    @ColumnInfo(name = "aw_location_key")
    var awLocationKey: String? = ""

    @ColumnInfo(name = "country")
    var country: String? = ""

    @ColumnInfo(name = "region")
    var region: String? = ""

    @ColumnInfo(name = "latitude")
    var lat: Double? = 0.0

    @ColumnInfo(name = "longitude")
    var lon: Double? = 0.0

    @ColumnInfo(name = "GMTOffset")
    var GMTOffset: Float? = 0f

    override fun toString(): String {
        return "TravelPlace(city=$city, id=$id, placeID=$placeID, awLocationKey=$awLocationKey, country=$country, region=$region, lat=$lat, lon=$lon, GMTOffset=$GMTOffset)"
    }
}