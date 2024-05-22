package com.patinfly.data.repository

import android.util.Log
import com.patinfly.data.dataSource.dbDataSource.RentDao
import com.patinfly.data.dataSource.rent.RentDataSource
import com.patinfly.domain.model.Rent
import com.patinfly.domain.model.dbDatasource.RentEntity
import com.patinfly.domain.model.dbDatasource.UserEntity
import com.patinfly.domain.model.dbDatasource.toRentDomain
import com.patinfly.domain.model.dbDatasource.toScooterDomain
import com.patinfly.domain.model.dbDatasource.toUserDomain
import com.patinfly.domain.repository.IRentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.UUID


class RentRepository (
    private val rentDataSource:RentDataSource,
    private val rentDao: RentDao
) : IRentRepository {
    override fun saveRent(rent: Rent){
        try {
            GlobalScope.launch(Dispatchers.IO) {
                rentDao.save(RentEntity.fromRentDomain(rent))
            }
        }catch (error:Exception) {
            Log.e("saveRent","Error in save process")
        }
    }
    override fun fetchRents(): List<Rent> {
        return try {
            runBlocking {
                val deferred = async(Dispatchers.IO) {
                    rentDao.getAll().map { it.toRentDomain() }
                }
                deferred.await()
            }
        } catch (error: Exception) {
            Log.e("fetchRent", "Error in fetching process")
            listOf()
        }
    }
    override fun updateRent(rent: Rent){
        return TODO("Provide the return value")
    }
    override fun fetchRentByUUID(uuid: UUID): Rent?{
        return try {
            runBlocking {
                val deferred = async(Dispatchers.IO) {
                    rentDao.getRentByUUID(uuid)?.toRentDomain()
                }
                deferred.await()
            }
        } catch (error: Exception) {
            Log.e("fetchRent", "Error in fetching process")
            null
        }
    }
}

