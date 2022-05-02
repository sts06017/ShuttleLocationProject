package kr.rabbito.shuttlelocationproject.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Location(
    val location: String
) : Parcelable {
    constructor() : this("")
}