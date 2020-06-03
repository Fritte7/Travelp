package com.fritte.travelp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fritte.travelp.R
import com.fritte.travelp.data.model.place.TravelPlace
import com.fritte.travelp.ui.main.adapter.MainAdapter
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.model.TypeFilter
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode
import com.google.android.material.snackbar.Snackbar
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class MainActivity : AppCompatActivity(), PlaceSelectionListener {
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val autocompleteFragment = supportFragmentManager.findFragmentById(R.id.autocomplete_fragment) as AutocompleteSupportFragment
        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG, Place.Field.TYPES, Place.Field.ADDRESS))
        autocompleteFragment.setTypeFilter(TypeFilter.CITIES)
        autocompleteFragment.setActivityMode(AutocompleteActivityMode.OVERLAY)
        autocompleteFragment.setOnPlaceSelectedListener(this)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview_places)
        recyclerView.layoutManager = LinearLayoutManager(this)

        mainViewModel.places.observe(this, Observer {
            if (it.isEmpty()) {
                findViewById<View>(R.id.view_empty).visibility = View.VISIBLE
            } else {
                findViewById<View>(R.id.view_empty).visibility = View.GONE
            }
            recyclerView.adapter = MainAdapter(this, it, View.OnClickListener {
                Log.d(MainActivity::class.java.canonicalName, "onClick( "+it.tag+" )")
            })
        })
    }

    override fun onPlaceSelected(place: Place) {
        Log.d(MainActivity::class.java.canonicalName, "onPlaceSelected( "+place.toString()+" )")
        val travelPlace = TravelPlace(place.name)
        travelPlace.placeID = place.id
        travelPlace.lat     = place.latLng!!.latitude
        travelPlace.lon     = place.latLng!!.longitude

        mainViewModel.addPlace(travelPlace)

    }

    override fun onError(status: Status) {
        if (status.statusMessage != null) {
            Snackbar.make(findViewById(R.id.main_root), status.statusMessage!!, Snackbar.LENGTH_LONG).show()
        }
    }

    /************************************** Utils *******************************************************/

    private fun showMessage(mainTextStringId: Int) {
        showSnackbar(mainTextStringId, null, null)
    }

    private fun showSnackbar(mainTextStringId: Int, actionStringId: Int?, listener: View.OnClickListener?) {
        val snackbar = Snackbar.make(findViewById(R.id.main_root), getString(mainTextStringId), Snackbar.LENGTH_LONG)
        if (listener != null && actionStringId != null) {
            snackbar.setAction(actionStringId, listener)
        }
        snackbar.show()
    }
}
