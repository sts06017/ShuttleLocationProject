package kr.rabbito.shuttlelocationproject.viewHolder

import androidx.recyclerview.widget.RecyclerView
import kr.rabbito.shuttlelocationproject.data.Location
import kr.rabbito.shuttlelocationproject.databinding.LocationCardBinding

class LocationViewHolder(private val binding: LocationCardBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(location: Location) {
        binding.locationCardTvTitle.text = location.latitude.toString()
    }
}