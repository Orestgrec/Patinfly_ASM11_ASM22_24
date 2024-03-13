package com.patinfly.data.repository

import com.patinfly.domain.model.Rent
import com.patinfly.domain.repository.IRentRepository
import com.patinfly.MainActivity
interface RentRepository : IRentRepository {
    override fun saveRent(rent: Rent) {
        TODO("Not yet implemented")
    }
}