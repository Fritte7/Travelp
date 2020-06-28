package com.fritte.travelp.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.fritte.travelp.data.database.DAOTravelPlace
import com.fritte.travelp.data.model.place.TravelPlace
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RepositoryPlace(
    private val dao: DAOTravelPlace
) {

    val places: LiveData<List<TravelPlace>> = liveData {
        emit(dao.getPlaces())
    }

    fun insertPlace(place: TravelPlace) : LiveData<Long> = liveData {
        emit(dao.insertPlace(place))
    }

    fun updatePlace(place: TravelPlace) {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.IO) {
                dao.updatePlace(place)
            }
        }
    }

    fun removePlace(place: TravelPlace) {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.IO) {
                dao.deletePlace(place)
            }
        }
    }
}