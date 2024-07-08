package com.example.practice.google_maps

import android.location.Address
import android.location.Geocoder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.practice.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.practice.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.GroundOverlayOptions
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.PolygonOptions
import java.io.IOException

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(30.5247, 72.2348)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney,13f))


        /*val locations = listOf(
            LatLng(30.5247, 72.2348),  // Location 1
            LatLng(30.5047, 72.2048),  // Location 2
            LatLng(30.5147, 72.2148)   // Location 3
        )

        val boundsBuilder = LatLngBounds.Builder()

        for ((index, location) in locations.withIndex()) {
            mMap.addMarker(MarkerOptions().position(location).title("Marker $index"))
            boundsBuilder.include(location)
        }

        // Move and zoom the camera to fit all markers
        val bounds = boundsBuilder.build()
        val padding = 100  // offset from edges of the map in pixels
        val cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, padding)

        mMap.moveCamera(cameraUpdate)*/

        // Add a circle
        val circleOptions = CircleOptions()
            .center(sydney)
            .radius(1000.0) // Radius in meters
            .strokeColor(0xFF0000FF.toInt()) // Blue outline
            .fillColor(0x220000FF) // Light blue fill
            .strokeWidth(5f)
        mMap.addCircle(circleOptions)

        // Add a polygon
//        val polygonOptions = PolygonOptions()
//            .add(
//                LatLng(30.5247, 72.2348),
//                LatLng(30.5247, 72.2448),
//                LatLng(30.5147, 72.2448),
//                LatLng(30.5147, 72.2348)
//            )
//            .strokeColor(0xFF00FF00.toInt()) // Green outline
//            .fillColor(0x2200FF00) // Light green fill
//            .strokeWidth(5f)
//        mMap.addPolygon(polygonOptions)

        // Add a ground overlay
//        val groundOverlayOptions = GroundOverlayOptions()
//            .image(BitmapDescriptorFactory.fromResource(R.drawable.b)) // Replace with your image resource
//            .position(locations[0], 1000f, 1000f) // Position with width and height in meters
//        mMap.addGroundOverlay(groundOverlayOptions)

        val geocoder= Geocoder(this)
//        var address=geocoder.getFromLocation(30.5247,72.2348,1)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { // API level 33
            geocoder.getFromLocation(30.5247, 72.2348, 1, object : Geocoder.GeocodeListener {
                override fun onGeocode(addresses: List<Address>) {
                    // Handle the geocoded addresses here
                    if (addresses.isNotEmpty()) {
                        val address = addresses[0]
                        Log.d("TAG", "onGeocode: $address", )
                    }
                }

                override fun onError(errorMessage: String?) {
                    // Handle the error here
                    errorMessage?.let {
                        println("Geocoding error: $it")
                    }
                }
            })
        } else {
            // Fallback for devices running below API level 33
            try {
                val addresses = geocoder.getFromLocation(30.5247, 72.2348, 1)
                if (addresses != null) {
                    if (addresses.isNotEmpty()) {
                        val address = addresses[0]
                        // Use the address as needed
                    }
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

    }
}