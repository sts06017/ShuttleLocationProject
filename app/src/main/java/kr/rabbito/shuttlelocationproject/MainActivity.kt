package kr.rabbito.shuttlelocationproject

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_main.*
import kr.rabbito.shuttlelocationproject.function.showRoute

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

        private lateinit var map: GoogleMap

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
            mapFragment.getMapAsync(this)

            main_btn_toGetLocation.setOnClickListener {
                val intent = Intent(this, GetLocationActivity::class.java)
                startActivity(intent)
            }
        }

        override fun onMapReady(googleMap: GoogleMap) {
            map = googleMap

            // 나침판
            map.uiSettings.isCompassEnabled = true
            // 지도 화면 회전
            map.uiSettings.isRotateGesturesEnabled = true
            // 확대 축소(+-) 버튼
            map.uiSettings.isZoomControlsEnabled = true
            // Add a marker in Sydney and move the camera
            val yeouido = LatLng(37.521814, 126.923596)
            map.addMarker(MarkerOptions().position(yeouido).title("Marker in Yeouido"))
            map.moveCamera(CameraUpdateFactory.newLatLng(yeouido))


            showRoute(map);

        }

    //


}

