package com.patinfly.domain.model.dbDatasource

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.patinfly.domain.model.Scooter
import java.util.Date
import java.util.UUID
@Entity
data class ScooterEntity (
    @PrimaryKey val uuid: UUID,
    val model: String,
    val serialNumber: String,
    var longitude: Double,
    var latitude: Double,
    var vacant: Boolean,
    var batteryLevel: Double,
    val batteryPartNumber: String,
    var lastMaintenance: String? = null
)
{
    companion object {
        fun fromScooterDomain(scooter: Scooter): ScooterEntity {
            return ScooterEntity(uuid = scooter.uuid,model = scooter.model,serialNumber = scooter.serialNumber,longitude = scooter.longitude,latitude = scooter.latitude,vacant = scooter.vacant,batteryLevel = scooter.batteryLevel,lastMaintenance = scooter.lastMaintenance,batteryPartNumber = scooter.batteryPartNumber)        }    } }
fun ScooterEntity.toScooterDomain(): Scooter{
    return Scooter(
        uuid = uuid,
        model= model,
        serialNumber=serialNumber,
        longitude=longitude,
        latitude=latitude,
        vacant=vacant,
        batteryLevel=batteryLevel,
        batteryPartNumber= batteryPartNumber,
        lastMaintenance= lastMaintenance

    ) }