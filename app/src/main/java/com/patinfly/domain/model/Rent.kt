package com.patinfly.domain.model

import java.util.Date
import java.util.UUID

data class Rent (
 val uuid:UUID,
 val scooterUUID:UUID,
 var userUUID:UUID,
 var startDate:Date,
 var stopDate:Date,
 )