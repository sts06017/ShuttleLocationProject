package kr.rabbito.shuttlelocationproject.function

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

fun showMarker(googleMap: GoogleMap, Latitude : Double, Hardness : Double) {
    val makerOptions = MarkerOptions()
    makerOptions // LatLng에 대한 어레이를 만들어서 이용할 수도 있다.
        .position(LatLng(Latitude, Hardness))
        .title("추가한마커")
    googleMap.addMarker(makerOptions)
}