package kr.rabbito.shuttlelocationproject.function

import android.util.Log
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

fun showMarker(googleMap: GoogleMap, driverName: String, latitude : Double, longitude : Double) {
    val makerOptions = MarkerOptions()
    Log.d("locationTest", longitude.toString())
    makerOptions
        .position(LatLng(latitude, longitude))
        .title(driverName)
    googleMap.addMarker(makerOptions)
}