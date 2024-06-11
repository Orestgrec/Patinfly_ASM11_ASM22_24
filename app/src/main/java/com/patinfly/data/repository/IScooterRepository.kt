package com.patinfly.data.repository

import android.util.Log
import com.patinfly.data.dataSource.dbDataSource.ScooterDao
import com.patinfly.data.dataSource.remoteDbDataSource.ScooterAPIDataSource
import com.patinfly.data.dataSource.scooter.ScooterDataSource
import com.patinfly.domain.model.Scooter
import com.patinfly.domain.model.dbDatasource.ScooterEntity
import com.patinfly.domain.model.dbDatasource.toScooterDomain
import com.patinfly.domain.model.remotedDataSource.ScooterApiModel
import com.patinfly.domain.model.remotedDataSource.StatusApiModel
import com.patinfly.domain.repository.IScooterRepository
import java.util.UUID

class ScooterRepository(
    private val scooterDataSource: ScooterDataSource,
    private val scooterDao: ScooterDao,
    private val scooterAPIDataSource: ScooterAPIDataSource

) : IScooterRepository {
    override suspend fun fetchScooters(): List<Scooter> {
        //return scooterDataSource.fetchScooters()
        return try {
            scooterDao.getAll().map { it.toScooterDomain() }
        } catch (error: Exception) {
            Log.e("saveRent", "Error in fetching process")
            listOf()
        }

    }

    override suspend fun fetchSchooterByUUID(uuid: UUID): Scooter? {
        return try {
            scooterDao.getScooterByUUID(uuid)?.toScooterDomain()
        } catch (error: Exception) {
            Log.e("fetchScooter", "Error in fetching process")
            null
        }
    }

    override suspend  fun saveScooter(scooter: Scooter) {
        try {
            scooterDao.save(ScooterEntity.fromScooterDomain(scooter))
        }catch (error:Exception) {
            Log.e("saveRent","Error in save process")
        }
    }

//    override suspend fun updateScooter(scooter: Scooter) {
//    }

    override suspend fun status(): StatusApiModel? {
        return try {
                    scooterAPIDataSource.getStatus()
        } catch (error: Exception) {
            Log.e("fetch", "Error in fetching status")
            null
        }
    }

    // fetch scooters from remote api
    override suspend fun scooters(): ScooterApiModel? {
        return try {
            scooterAPIDataSource.getScooters()
        } catch (error: Exception) {
            Log.e("fetch", "Error in fetching status")
            null
        }
    }


}