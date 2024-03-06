package com.patinfly.domain.repository

import com.patinfly.domain.model.Scooter
import java.util.UUID

interface ScooterRepository {
    fun fetchScooters(): List<Scooter>
    fun fetchSchooterByUUID(uuid: UUID): Scooter?
    fun saveScooter(scooter: Scooter)
    fun updateScooter(scooter: Scooter)
}