package com.patinfly.data.dataSource.rent

import com.patinfly.data.model.RentModel
import com.patinfly.domain.model.Rent
import com.patinfly.domain.repository.IRentRepository
import java.util.UUID
interface RentDao {
     fun saveRent(rent: Rent)
     fun fetchRents(): List<Rent>
     fun fetchRentByUUID(uuid: UUID): Rent?
}