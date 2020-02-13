package com.anshaysaboo.convenio


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.Mapbox.getApplicationContext
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style

class MapFragment: Fragment() {

    private var mapView: MapView? = null
    private var mapboxMap: MapboxMap? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapView = view.findViewById(R.id.mapView)
        mapView?.getMapAsync { mapboxMap ->

            this.mapboxMap = mapboxMap
            mapboxMap.setStyle(Style.Builder().fromUri("mapbox://styles/anshaysaboo/ck3pe1pwq0oiv1cqedywbygl3")) {
                // once finished loading zoom into location
                configureMap()
            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Mapbox.getInstance(context!!, getString(R.string.mapbox_access_token));
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    fun configureMap() {
        // zoom in to Uni
        val initialPostition = CameraPosition.Builder()
            .target(LatLng(33.651785, -117.822857))
            .zoom(17.0)
            .build()
        mapboxMap?.animateCamera(CameraUpdateFactory.newCameraPosition(initialPostition), 1)

        // show user's current location

    }

}
