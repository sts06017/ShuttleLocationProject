package kr.rabbito.shuttlelocationproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_main.*

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

            // Add a marker in Sydney and move the camera
            val yeouido = LatLng(37.521814, 126.923596)
            map.addMarker(MarkerOptions().position(yeouido).title("Marker in Yeouido"))
            map.moveCamera(CameraUpdateFactory.newLatLng(yeouido))
        }



}

