package com.patinfly.domain.model

import com.patinfly.data.model.RentModel
import java.util.Date
import java.util.UUID

 data class Rent (
  val uuid: UUID,
  val scooterUUID: UUID,
  val userUUID: UUID,
  var startDate: String,
  var stopDate: String
 )
