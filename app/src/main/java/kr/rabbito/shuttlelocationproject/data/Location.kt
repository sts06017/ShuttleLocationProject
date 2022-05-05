package kr.rabbito.shuttlelocationproject.data

class Location(
    var driverId: String,
    val driverName: String,
    var latitude: Double,
    var longitude: Double
) {
    constructor() : this("", "", 0.0, 0.0)
}