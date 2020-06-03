package com.fritte.travelp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fritte.travelp.data.model.place.TravelPlace

@Database(entities = [TravelPlace::class], version = 1, exportSchema = false)
abstract class DatabaseTravel : RoomDatabase() {

    abstract fun daoTravelPlace(): DAOTravelPlace

    companion object {
        @Volatile
        private var INSTANCE: DatabaseTravel? = null

        fun getInstance(context: Context): DatabaseTravel {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                                    context.applicationContext,
                                    DatabaseTravel::class.java,
                                    "travel.db"
                                     )
                                .fallbackToDestructiveMigration()
                                .build()
                }
                return instance
            }
        }
    }
}