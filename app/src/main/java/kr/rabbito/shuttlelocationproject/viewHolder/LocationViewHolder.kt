package kr.rabbito.shuttlelocationproject.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.location_card.view.*
import kr.rabbito.shuttlelocationproject.data.Location

class LocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val locationCard_tv_title = itemView.locationCard_tv_title

    fun bind(location: Location) {
        locationCard_tv_title.text = location.location
    }
}