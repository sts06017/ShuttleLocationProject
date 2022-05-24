package kr.rabbito.shuttlelocationproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import kr.rabbito.shuttlelocationproject.data.Location
import kr.rabbito.shuttlelocationproject.databinding.ActivityMainBinding
import kr.rabbito.shuttlelocationproject.function.setChildEventListener

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
        private var mBinding: ActivityMainBinding? = null
        private val binding get() = mBinding!!

        private lateinit var map: GoogleMap
        private val postList = mutableListOf<Location>()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            mBinding = ActivityMainBinding.inflate(layoutInflater)

            setContentView(binding.root)

            val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
            mapFragment.getMapAsync(this)

            //postActivity -> communityActivity에서 btn 구현 완료
//            binding.mainBtnToPost.setOnClickListener {
//                val intent = Intent(this, PostActivity::class.java)
//                startActivity(intent)
//            }

            binding.mainBtnToCommunity.setOnClickListener {
                val intent = Intent(this, CommunityActivity::class.java)
                startActivity(intent)
            }
        }

        override fun onMapReady(googleMap: GoogleMap) {
            map = googleMap
            setChildEventListener(postList, map, "Driver/tuk")
        }
}

