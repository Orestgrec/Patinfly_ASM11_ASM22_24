package com.patinfly.domain.model

import com.patinfly.data.model.RentModel
import java.util.Date
import java.util.UUID

 class Rent ( rentModel: RentModel){
 val uuid:UUID,
 val scooterUUID:UUID,
 var userUUID:UUID,
 var startDate:Date,
 var stopDate:Date,
 }
