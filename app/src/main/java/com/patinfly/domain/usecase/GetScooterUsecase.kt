package com.patinfly.domain.usecase

import android.content.Context
import com.patinfly.data.dataSource.dbDataSource.AppDatabase
import com.patinfly.data.dataSource.remoteDbDataSource.ScooterAPIDataSource
import com.patinfly.data.dataSource.scooter.ScooterDataSource
import com.patinfly.data.repository.ScooterRepository
import com.patinfly.domain.model.Scooter

class  GetScooterUsecase() {
    suspend fun execute(context: Context): List<Scooter> {
        return ScooterRepository( ScooterDataSource.getInstance(context), AppDatabase.getDatabase(context).scooterDataSource(),ScooterAPIDataSource.getInstance(context)).fetchScooters()}

}
