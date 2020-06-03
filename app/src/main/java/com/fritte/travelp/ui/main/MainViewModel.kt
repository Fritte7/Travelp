package com.fritte.travelp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fritte.travelp.data.model.place.TravelPlace
import com.fritte.travelp.data.model.utils.Resource
import com.fritte.travelp.data.repositories.RepositoryAccuWeather
import com.fritte.travelp.data.repositories.RepositoryPlace
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.launch

class MainViewModel(
    private val repositoryPlace: RepositoryPlace,
    private val repoAccuWeather: RepositoryAccuWeather
) : ViewModel() {

    val places = repositoryPlace.places

    fun addPlace(travelPlace: TravelPlace) {
        repositoryPlace.insertPlace(travelPlace).observeForever {
            if (it != null && it > -1) {
                travelPlace.id = it
                searchCityLocKey(travelPlace)
            }
        }
    }

    fun removePlace(travelPlace: TravelPlace) {
        repositoryPlace.removePlace(travelPlace)
    }

    private fun searchCityLocKey(travelPlace: TravelPlace) {
        repoAccuWeather.searchCityLocation(LatLng(travelPlace.lat!!, travelPlace.lon!!)).observeForever {
            when (it.status) {
                Resource.Status.LOADING -> { /** nothing **/ }
                Resource.Status.SUCCESS -> {
                    if (it.data != null) {
                        travelPlace.awLocationKey = it.data.key
                        travelPlace.country       = it.data.country.englishName
                        travelPlace.region        = it.data.region.englishName
                        travelPlace.GMTOffset     = it.data.timeZone.gmtOffset

                        repositoryPlace.updatePlace(travelPlace)
                    }
                }
                Resource.Status.ERROR -> {
                    /** manage error **/
                }
            }
        }
    }
}