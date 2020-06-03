package com.fritte.travelp.data.modules

import com.fritte.travelp.R
import com.fritte.travelp.data.database.DatabaseTravel
import com.fritte.travelp.data.network.NetworkAPI
import com.fritte.travelp.data.repositories.RepositoryAccuWeather
import com.fritte.travelp.data.repositories.RepositoryPlace
import com.fritte.travelp.ui.main.MainViewModel
import com.google.android.libraries.places.api.Places
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    /** create instance places **/
    single { Places.createClient(androidApplication()) }

    /** create instance database **/
    single { DatabaseTravel.getInstance(androidApplication()) }

    /** init retrofit **/
    single { NetworkAPI(androidApplication().getString(R.string.accuweather_host_dev)) }

    /** init repositories **/
    single {
        RepositoryPlace(
            get<DatabaseTravel>().daoTravelPlace()
        )
    }
    single {
        RepositoryAccuWeather(
            androidApplication().getString(R.string.accuweather_api_key),
            get<NetworkAPI>().provideAccuWeatherAPI()
        )
    }

    /** init view models **/
    viewModel { MainViewModel(get(), get()) }
}