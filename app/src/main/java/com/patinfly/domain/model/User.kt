package com.patinfly.domain.model

import java.util.Date
import java.util.UUID

data class User(
    val uuid:UUID,
    val userName:String,
    val email : String,
    val isRenting : Boolean,
    val scooterRented:UUID,
    val creationDate:Date,
    val numberOfRents:Int,
)