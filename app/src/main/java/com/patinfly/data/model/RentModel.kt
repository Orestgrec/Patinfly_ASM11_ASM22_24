package com.patinfly.data.model

import androidx.room.Entity
import java.util.Date
import java.util.UUID

// start data and end date must be a Date type not String
data class RentModel(
    val uuid: UUID,
    val scooterUUID: UUID,
    val userUUID: UUID,
    var startDate: String,
    var stopDate: String
)
