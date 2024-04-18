package com.patinfly.data.repository

import com.patinfly.data.dataSource.scooter.ScooterDao
import com.patinfly.data.dataSource.user.UserDao
import com.patinfly.domain.model.Scooter
import com.patinfly.domain.repository.IScooterRepository
import java.util.UUID

class ScooterRepository(
    private val scooterDataSource: ScooterDao
) : IScooterRepository {
    override fun fetchScooters(): List<Scooter> {
        return scooterDataSource.fetchScooters()
        //implementa in ScooterDao e poi richiamala qui come fatto in userDao e IUserRepository
    }

    override fun fetchSchooterByUUID(uuid: UUID): Scooter? {
        TODO("Not yet implemented")
    }

    override fun saveScooter(scooter: Scooter) {
        TODO("Not yet implemented")
    }

    override fun updateScooter(scooter: Scooter) {
        TODO("Not yet implemented")
    }
}