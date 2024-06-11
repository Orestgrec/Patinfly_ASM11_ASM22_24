package com.patinfly.domain.repository

import com.patinfly.domain.model.Scooter
import com.patinfly.domain.model.remotedDataSource.ScooterApiModel
import com.patinfly.domain.model.remotedDataSource.StatusApiModel
import java.util.UUID

interface IScooterRepository {
    suspend fun fetchScooters(): List<Scooter>
    suspend fun fetchSchooterByUUID(uuid: UUID): Scooter?
    suspend fun saveScooter(scooter: Scooter)
//    suspend fun updateScooter(scooter: Scooter)
    suspend fun status(): StatusApiModel?

    suspend fun scooters(): ScooterApiModel?
}