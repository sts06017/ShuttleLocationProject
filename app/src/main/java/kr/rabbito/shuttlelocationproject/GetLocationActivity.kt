package kr.rabbito.shuttlelocationproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_get_location.*
import kr.rabbito.shuttlelocationproject.adapter.LocationAdapter
import kr.rabbito.shuttlelocationproject.data.Location
import kr.rabbito.shuttlelocationproject.function.setChildEventListener

class GetLocationActivity : AppCompatActivity() {
    val postList = mutableListOf<Location>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_location)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.reverseLayout = true
        layoutManager.stackFromEnd = true

        getLocation_rv_list.layoutManager = layoutManager
        val bookAdapter = LocationAdapter(this, postList)
        getLocation_rv_list.adapter = bookAdapter

        setChildEventListener(postList, getLocation_rv_list, "Driver/tuk")
    }
}
