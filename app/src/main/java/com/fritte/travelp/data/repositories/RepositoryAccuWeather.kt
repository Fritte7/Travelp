package com.fritte.travelp.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fritte.travelp.data.model.accuweather.AWCurrentConditions
import com.fritte.travelp.data.model.accuweather.AWForecasts
import com.fritte.travelp.data.model.accuweather.AWLocation
import com.fritte.travelp.data.model.utils.Resource
import com.fritte.travelp.data.network.AccuWeatherAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.fritte.travelp.data.model.utils.Error
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.withContext
import java.lang.StringBuilder

class RepositoryAccuWeather(
    private val _apiKey: String,
    private val api: AccuWeatherAPI
) {

    /************************************* locations *******************************************************/

    fun searchCityLocation(_latLng: LatLng) : LiveData<Resource<AWLocation>> {
        val data: MutableLiveData<Resource<AWLocation>> = MutableLiveData()
        data.value = Resource.loading(null)

        CoroutineScope(Dispatchers.IO).launch {
            val response = api.searchCityLoc(_apiKey, getGeocoderToString(_latLng))
            withContext(Dispatchers.Main) {
                Log.d(RepositoryAccuWeather::class.java.canonicalName, "searchCityLocation( "+response.raw().request().url()+" )")
                Log.d(RepositoryAccuWeather::class.java.canonicalName, "searchCityLocation( "+response.code()+", "+response.body()+" )")
                try {
                    if (response.isSuccessful) {
                        data.value = Resource.success(response.body())
                    } else {
                        data.value = Resource.error(Error(response.code(), response.message()))
                    }
                } catch (e: Throwable) {
                    data.value = Resource.error(Error(Error.ERROR_CONNECTION, e.message))
                }
            }
        }
        return data
    }

    /************************************* forecast *******************************************************/

    fun getCurrentCondition(_locationKey: String) : LiveData<Resource<List<AWCurrentConditions>>> {
        val data: MutableLiveData<Resource<List<AWCurrentConditions>>> = MutableLiveData()
        data.value = Resource.loading(null)

        CoroutineScope(Dispatchers.IO).launch {
            val response = api.getCurrentCondition(_locationKey, _apiKey, false)
            withContext(Dispatchers.Main) {
                Log.d(RepositoryAccuWeather::class.java.canonicalName, "getCurrentCondition( "+response.raw().request().url()+" )")
                Log.d(RepositoryAccuWeather::class.java.canonicalName, "getCurrentCondition( "+response.code()+", "+response.body()+" )")
                try {
                    if (response.isSuccessful) {
                        data.value = Resource.success(response.body())
                    } else {
                        data.value = Resource.error(Error(response.code(), response.message()))
                    }
                } catch (e: Throwable) {
                    data.value = Resource.error(Error(Error.ERROR_CONNECTION, e.message))
                }
            }
        }
        return data
    }

    fun getForecast(_locationKey: String, _oneDay: Boolean) : LiveData<Resource<AWForecasts>> {
        val data: MutableLiveData<Resource<AWForecasts>> = MutableLiveData()
        data.value = Resource.loading(null)

        CoroutineScope(Dispatchers.IO).launch {
            val response = if (_oneDay) {
                                api.getOneDayForecast(_locationKey, _apiKey, false)
                            } else {
                                api.getFiveDaysForecast(_locationKey, _apiKey, false)
                            }
            withContext(Dispatchers.Main) {
                Log.d(RepositoryAccuWeather::class.java.canonicalName, "getForecast( "+response.raw().request().url()+" )")
                Log.d(RepositoryAccuWeather::class.java.canonicalName, "getForecast( "+response.code()+", "+response.body()+" )")
                try {
                    if (response.isSuccessful) {
                        data.value = Resource.success(response.body())
                    } else {
                        data.value = Resource.error(Error(response.code(), response.message()))
                    }
                } catch (e: Throwable) {
                    data.value = Resource.error(Error(Error.ERROR_CONNECTION, e.message))
                }
            }
        }
        return data
    }

    /************************************* utils *******************************************************/

    private fun getGeocoderToString(latLng: LatLng): String {
        return StringBuilder(latLng.latitude.toString())
               .append(",")
               .append(latLng.longitude.toString())
               .toString()
    }
}