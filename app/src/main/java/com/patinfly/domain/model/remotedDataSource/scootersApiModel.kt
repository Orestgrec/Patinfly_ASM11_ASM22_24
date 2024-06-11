package com.patinfly.domain.model.remotedDataSource


import com.patinfly.domain.model.Scooter
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import java.util.UUID

@Serializable
data class ScooterInfo(
    @SerialName("uuid")
    val uuid: UUID = UUID.randomUUID(),

    @SerialName("name")
    val name: String = "test",

    @SerialName("date_create")
    val dateCreate: String = "2023-05-07T21:50:58.621408Z",

    @SerialName("date_last_maintenance")
    val dateLastMaintenance: String = "2023-05-07T21:50:58.621408Z",

    @SerialName("longitude")
    val longitude: String = "0.0", // Default to a valid double string

    @SerialName("latitude")
    val latitude: String = "0.0", // Default to a valid double string

    @SerialName("state")
    val state: String = "testing",

    @SerialName("vacant")
    val vacant: String = "false", // Default to a valid boolean string

    @SerialName("battery_level")
    val batteryLevel: String = "0.0", // Default to a valid double string

    @SerialName("meters_use")
    val metersUse: String = "testing"
) {
    fun fromScooterDomain(): Scooter {
        return Scooter(
            uuid = uuid,
            model = name,
            lastMaintenance = dateLastMaintenance,
            longitude = longitude.toDoubleOrNull() ?: 0.0, // Safely convert to double
            latitude = latitude.toDoubleOrNull() ?: 0.0, // Safely convert to double
            vacant = vacant.toBoolean(), // Safely convert to boolean
            batteryLevel = batteryLevel.toDoubleOrNull() ?: 0.0, // Safely convert to double
            serialNumber = metersUse,
            batteryPartNumber = batteryLevel // Assuming this should be batteryLevel
        )
    }
    companion object {
        fun empty() = ScooterInfo()
    }
}

@Serializable
data class ScooterApiModel(
    @SerialName(value = "scooters")
    val scooters:List<ScooterInfo>
)
//{
//    fun toScooterDomain(): ScooterApiModel {
//        return ScooterApiModel(
//            scooters = this.scooters.map {
//                ScooterInfo(
//                    uuid = it.uuid,
//                    name = it.name,
//                    dateCreate = it.dateCreate,
//                    dateLastMaintenance = it.dateLastMaintenance,
//                    longitude = it.longitude,
//                    latitude = it.latitude,
//                    state = it.state,
//                    vacant = it.vacant,
//                    batteryLevel = it.batteryLevel,
//                    metersUse = it.metersUse
//                )
//            }
//        )
//    }
//}