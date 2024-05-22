package com.patinfly.data.repository

import android.util.Log
import com.patinfly.data.dataSource.dbDataSource.ScooterDao
import com.patinfly.data.dataSource.scooter.ScooterDataSource
import com.patinfly.domain.model.Scooter
import com.patinfly.domain.model.dbDatasource.RentEntity
import com.patinfly.domain.model.dbDatasource.ScooterEntity
import com.patinfly.domain.model.dbDatasource.toRentDomain
import com.patinfly.domain.model.dbDatasource.toScooterDomain
import com.patinfly.domain.repository.IScooterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.UUID

class ScooterRepository(
    private val scooterDataSource: ScooterDataSource,
    private val scooterDao: ScooterDao

) : IScooterRepository {
    override fun fetchScooters(): List<Scooter> {
        //return scooterDataSource.fetchScooters()

        return try {
            runBlocking {
                val deferred = async(Dispatchers.IO) {
                    scooterDao.getAll().map { it.toScooterDomain() }
                }
                deferred.await()
            }
        } catch (error: Exception) {
            Log.e("saveRent", "Error in fetching process")
            listOf()
        }

    }

    override fun fetchSchooterByUUID(uuid: UUID): Scooter? {
        return try {
            runBlocking {
                val deferred = async(Dispatchers.IO) {
                    scooterDao.getScooterByUUID(uuid)?.toScooterDomain()
                }
                deferred.await()
            }
        } catch (error: Exception) {
            Log.e("fetchScooter", "Error in fetching process")
            null
        }
    }

    override fun saveScooter(scooter: Scooter) {
        try {
            GlobalScope.launch(Dispatchers.IO) {
                scooterDao.save(ScooterEntity.fromScooterDomain(scooter))
            }
        }catch (error:Exception) {
            Log.e("saveRent","Error in save process")
        }
    }

    override fun updateScooter(scooter: Scooter) {
        TODO("Not yet implemented")
    }
}