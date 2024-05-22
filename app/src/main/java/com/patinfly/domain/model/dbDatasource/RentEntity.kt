package com.patinfly.domain.model.dbDatasource

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.patinfly.domain.model.Rent
import com.patinfly.domain.model.User
import java.util.Date
import java.util.UUID
@Entity
data class RentEntity (
    @PrimaryKey val uuid: UUID,
    val scooterUUID: UUID,
    val userUUID: UUID,
    var startDate: String,
    var stopDate: String )
{
    companion object {
        fun fromRentDomain(rent: Rent): RentEntity {
            return RentEntity(uuid = rent.uuid,scooterUUID = rent.scooterUUID,userUUID = rent.userUUID,startDate = rent.startDate.toString(),stopDate = rent.stopDate.toString())        }    } }
fun RentEntity.toRentDomain(): Rent{
    return Rent(
        uuid = uuid,
        scooterUUID = scooterUUID
        ,userUUID = userUUID
        ,startDate = Date()
        ,stopDate = Date()
    ) }