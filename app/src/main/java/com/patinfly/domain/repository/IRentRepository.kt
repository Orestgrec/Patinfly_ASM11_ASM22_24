package com.patinfly.domain.repository

import com.patinfly.domain.model.Rent
import com.patinfly.domain.model.remotedDataSource.RentApiModel
import java.util.UUID

interface IRentRepository {
    suspend fun fetchRents(): List<Rent>
    suspend fun fetchRentByUUID(uuid: UUID): Rent?
    suspend fun saveRent(rent: Rent)
//    suspend fun updateRent(rent: Rent)

    // fetch rents from remote api
     suspend fun rents(): RentApiModel?
}