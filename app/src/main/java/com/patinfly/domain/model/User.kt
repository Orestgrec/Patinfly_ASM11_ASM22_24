package com.patinfly.domain.model

import java.util.Date
import java.util.UUID

data class User(
    val uuid: UUID,
    val username: String,
    val email: String,
    val isRenting: Boolean,
    val scooterRented: UUID?,
    val creationDate: Date,
    val numberOfRents: Int,
    val salt :String,
    val hashedPass:String
)