package com.fritte.travelp.application

import android.app.Application
import com.fritte.travelp.R
import com.fritte.travelp.data.modules.appModule
import com.google.android.libraries.places.api.Places
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TravelApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Places.initialize(this, getString(R.string.google_maps_key))
        startKoin {
            androidContext(this@TravelApp)
            androidLogger()
            modules(appModule)
        }
    }
}