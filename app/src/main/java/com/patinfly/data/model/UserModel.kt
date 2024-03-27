package com.patinfly.data.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime
import java.util.UUID

// creationDate must be a Date type not String

data class UserModel(
    val uuid: UUID,
    val username: String?,
    val email: String?,
    @SerializedName("is_renting")
    val isRenting: Boolean?,
    @SerializedName("scooter_rented")
    val scooterRented: UUID,
    @SerializedName("creation_date")
    val creationDate: LocalDateTime?,
    @SerializedName("number_of_rents")
    val numberOfRents: Int?
)
