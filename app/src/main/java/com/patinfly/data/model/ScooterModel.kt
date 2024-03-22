package com.patinfly.data.model

import com.google.gson.annotations.SerializedName
import java.util.Date
import java.util.UUID
// lastMaintenance must be a Date type not String


data class ScooterModel(

    @SerializedName("uuid") val uuid: UUID,
    @SerializedName("model") val model: String,
    @SerializedName("serial_number") val serialNumber: String,
    @SerializedName("longitude") var longitude: Double,
    @SerializedName("latitude") var latitude: Double,
    @SerializedName("vacant") var vacant: Boolean,
    @SerializedName("battery_level") var batteryLevel: Double,
    @SerializedName("battery_part_number") val batteryPartNumber: String,
    @SerializedName("last_maintenance") var lastMaintenance: String? = null
)