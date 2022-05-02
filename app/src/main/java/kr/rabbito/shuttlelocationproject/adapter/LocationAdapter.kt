package kr.rabbito.shuttlelocationproject.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import kr.rabbito.shuttlelocationproject.R
import kr.rabbito.shuttlelocationproject.data.Location
import kr.rabbito.shuttlelocationproject.viewHolder.LocationViewHolder

class LocationAdapter(val context: Context, private val dataList: MutableList<Location>) :
    RecyclerView.Adapter<LocationViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.location_card, parent, false)
        return LocationViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.bind(dataList[position])
    }
}