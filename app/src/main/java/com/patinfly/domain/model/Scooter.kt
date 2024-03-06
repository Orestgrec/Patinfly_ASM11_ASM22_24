package com.patinfly.domain.model
import java.util.Date
import java.util.UUID

data class Scooter (
    val uuid: UUID,
    val model :String,
    var serialNumber : Number,
    var longitude :Double,
    var latitude : Double,
    var vacant:Boolean,
    val batteryLevel:Double,
    val batteryPartNumber: String,
    val lastMaintenance : Date? = null
)
