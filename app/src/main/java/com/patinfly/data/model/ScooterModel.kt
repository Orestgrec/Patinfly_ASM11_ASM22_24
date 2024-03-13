package com.patinfly.data.model

import java.util.Date
import java.util.UUID
// lastMaintenance must be a Date type not String

data class ScooterModel(
    val uuid: UUID,
    val model: String,
    val serialNumber: String,
    var longitude: Double,
    var latitude: Double,
    var vacant: Boolean,
    var batteryLevel: Double,
    val batteryPartNumber: String,
    var lastMaintenance: String? = null
)