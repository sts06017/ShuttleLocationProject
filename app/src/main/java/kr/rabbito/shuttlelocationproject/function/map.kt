package kr.rabbito.shuttlelocationproject.function

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

fun showMarker(googleMap: GoogleMap, latitude : Double, longitude : Double) {

    val makerOptions = MarkerOptions()
    makerOptions
        .position(LatLng(latitude, longitude))
        .title("추가한마커")
    googleMap.addMarker(makerOptions)
}