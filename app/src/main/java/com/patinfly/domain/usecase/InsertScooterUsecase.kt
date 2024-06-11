package com.patinfly.domain.usecase

import android.content.Context
import android.util.Log
import com.patinfly.data.dataSource.dbDataSource.AppDatabase
import com.patinfly.data.dataSource.remoteDbDataSource.ScooterAPIDataSource
import com.patinfly.data.dataSource.scooter.ScooterDataSource
import com.patinfly.data.repository.ScooterRepository
import com.patinfly.domain.model.Scooter

class InsertScooterUsecase() {
    suspend fun execute(scooter: Scooter,context:Context) {
        // generate an instance from scooter data class and pass it to be saved
        try {
            ScooterRepository( ScooterDataSource.getInstance(context), AppDatabase.getDatabase(context).scooterDataSource(),
                ScooterAPIDataSource.getInstance(context)).saveScooter(scooter)}
        catch (error:Exception) {
            Log.e("RegisterUsecase","Error in register process")

        }
    }

}