package kr.rabbito.shuttlelocationproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.FirebaseDatabase
import kr.rabbito.shuttlelocationproject.adapter.LocationAdapter
import kr.rabbito.shuttlelocationproject.data.Location
import kr.rabbito.shuttlelocationproject.databinding.ActivityGetLocationBinding
import kr.rabbito.shuttlelocationproject.function.setChildEventListener

class GetLocationActivity : AppCompatActivity() {
    private var mBinding: ActivityGetLocationBinding? = null
    private val binding get() = mBinding!!

    val postList = mutableListOf<Location>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityGetLocationBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_get_location)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.reverseLayout = true
        layoutManager.stackFromEnd = true

        binding.getLocationRvList.layoutManager = layoutManager
        val bookAdapter = LocationAdapter(this, postList)
        binding.getLocationRvList.adapter = bookAdapter

        setChildEventListener(postList, binding.getLocationRvList, "Driver/tuk")
    }
}
