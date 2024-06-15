package com.patinfly.domain.model.remotedDataSource


import com.patinfly.domain.model.Rent
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import java.util.Date
import java.util.UUID

@Serializable
data class RentInfo(
    @SerialName("uuid")
    val uuid: UUID = UUID.randomUUID(),

    @SerialName("scooter")
    val scooter: ScooterInfo= ScooterInfo.empty(),

    @SerialName("date_start")
    val dateStart: Date = Date(),

    @SerialName("date_stop")
    val dateStop: Date = Date(),

) {
    fun fromRentDomain(): Rent {
        return Rent(
            uuid = uuid,
            scooterUUID =scooter.uuid ,
            startDate =dateStart ,
            stopDate = dateStop,
            userUUID = uuid

        )
    }
}

@Serializable
data class RentApiModel(
    @SerialName(value = "rents")
    val rents:List<RentInfo>
)
