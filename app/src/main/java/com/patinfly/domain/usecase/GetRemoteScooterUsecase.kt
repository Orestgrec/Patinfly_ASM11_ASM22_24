package com.patinfly.domain.usecase

import android.content.Context
import com.patinfly.data.dataSource.dbDataSource.AppDatabase
import com.patinfly.data.dataSource.remoteDbDataSource.ScooterAPIDataSource
import com.patinfly.data.dataSource.scooter.ScooterDataSource
import com.patinfly.data.repository.ScooterRepository
import com.patinfly.domain.model.remotedDataSource.ScooterApiModel

class GetRemoteScooterUsecase {
    companion object {
        suspend fun execute(context: Context): ScooterApiModel? {
            return ScooterRepository( ScooterDataSource.getInstance(context), AppDatabase.getDatabase(context).scooterDataSource(),
                ScooterAPIDataSource.getInstance(context)).scooters()}

    }
}