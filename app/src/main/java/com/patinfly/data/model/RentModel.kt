package com.patinfly.data.model

import com.google.gson.annotations.SerializedName
import java.util.Date
import java.util.UUID

// start data and end date must be a Date type not String
data class RentModel(
    @SerializedName("uuid") val uuid: UUID,
    @SerializedName("scooter_uuid") val scooterUUID: UUID,
    @SerializedName("user_uuid") val userUUID: UUID,
    @SerializedName("start_date") var startDate: String,
    @SerializedName("stop_date") var stopDate: String
)