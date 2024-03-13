package com.patinfly.data.model

import java.time.LocalDateTime
import java.util.Date
import java.util.UUID
// creationDate must be a Date type not String

data class UserModel(
    val uuid: UUID,
    val username: String,
    val email: String,
    val isRenting: Boolean,
    val scooterRented: UUID,
    val creationDate: LocalDateTime,
    val numberOfRents: Int
)