package com.fritte.travelp.data.database

import androidx.room.*
import com.fritte.travelp.data.model.place.TravelPlace

@Dao
interface DAOTravelPlace {

    @Query("SELECT * FROM travel_place_table")
    suspend fun getPlaces() : List<TravelPlace>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlace(travelPlace: TravelPlace) : Long

    @Update
    suspend fun updatePlace(travelPlace: TravelPlace)

    @Delete
    suspend fun deletePlace(travelPlace: TravelPlace)
}