package com.patinfly.domain.usecase

import android.util.Log
import com.patinfly.data.repository.ScooterRepository
import com.patinfly.domain.model.Scooter
import java.util.UUID

class GetSingleScooterUsercase(private val scooterRepository: ScooterRepository) {
    suspend fun execute(uuid: String): Scooter?{
        return try {
            val sampleUuid = UUID.fromString(uuid)
            scooterRepository.fetchSchooterByUUID(sampleUuid)
        }catch (error:Exception) {
            Log.e("ProfileDataUsecase","Error in fetching process")
            null
        }
    }
}