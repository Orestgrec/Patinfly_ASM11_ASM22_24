package com.patinfly.data.repository

import com.patinfly.data.dataSource.rent.RentDao
import com.patinfly.domain.model.Rent
import com.patinfly.domain.repository.IRentRepository
import java.util.UUID


open class RentRepository (
    private val rentDataSource:RentDao
) : IRentRepository {
    override fun saveRent(rent: Rent){
        rentDataSource.saveRent(rent)
    }
    override fun fetchRents(): List<Rent> {

        return TODO("Provide the return value")
    }
    override fun fetchRentByUUID(uuid: UUID): Rent?{
        return rentDataSource.fetchRentByUUID(uuid)
    }
    override fun updateRent(rent: Rent){
        return TODO("Provide the return value")
    }
}