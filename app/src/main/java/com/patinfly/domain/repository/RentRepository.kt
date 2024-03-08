package com.patinfly.domain.repository

import com.patinfly.domain.model.Rent
import java.util.UUID

interface RentRepository {
    fun fetchRents(): List<Rent>
    fun fetchRentByUUID(uuid: UUID): Rent?
    fun saveRent(rent: Rent)
    fun updateRent(rent: Rent)
}