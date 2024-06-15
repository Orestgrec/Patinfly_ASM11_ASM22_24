package com.patinfly.data.repository

import android.util.Log
import com.patinfly.data.dataSource.dbDataSource.RentDao
import com.patinfly.data.dataSource.remoteDbDataSource.RentsAPIDataSource
import com.patinfly.data.dataSource.rent.RentDataSource
import com.patinfly.domain.model.Rent
import com.patinfly.domain.model.dbDatasource.RentEntity
import com.patinfly.domain.model.dbDatasource.toRentDomain
import com.patinfly.domain.model.remotedDataSource.RentApiModel
import com.patinfly.domain.repository.IRentRepository
import java.util.UUID


class RentRepository (
    private val rentDataSource:RentDataSource,
    private val rentDao: RentDao,
    private val rentsAPIDataSource: RentsAPIDataSource

) : IRentRepository {
    override suspend fun saveRent(rent: Rent){
        try {
            rentDao.save(RentEntity.fromRentDomain(rent))
        }catch (error:Exception) {
            Log.e("saveRent","Error in save process")
        }
    }
    override suspend fun fetchRents(): List<Rent> {
        return try {
            rentDao.getAll().map { it.toRentDomain() }
        } catch (error: Exception) {
            Log.e("fetchRent", "Error in fetching process")
            listOf()
        }
    }

//    override suspend fun updateRent(rent: Rent){
//    }
    override suspend fun fetchRentByUUID(uuid: UUID): Rent?{
        return try {
            rentDao.getRentByUUID(uuid)?.toRentDomain()
            }
         catch (error: Exception) {
            Log.e("fetchRent", "Error in fetching process")
            null
        }
    }

    override suspend fun rents(): RentApiModel?{
        return try {
            rentsAPIDataSource.getRents()
        } catch (error: Exception) {
            Log.e("fetch", "Error in fetching rents")
            null
        }
    }


}

