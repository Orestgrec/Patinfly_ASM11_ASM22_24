package com.patinfly.domain.usecase

import android.content.Context
import android.util.Log
import com.patinfly.data.dataSource.dbDataSource.AppDatabase
import com.patinfly.data.dataSource.remoteDbDataSource.RentsAPIDataSource
import com.patinfly.data.dataSource.rent.RentDataSource
import com.patinfly.data.repository.RentRepository
import com.patinfly.domain.model.Rent

class InsertRentUsecase() {
    suspend fun execute(rent: Rent,context:Context) {
        // generate an instance from scooter data class and pass it to be saved
        try {
            RentRepository( RentDataSource.getInstance(context), AppDatabase.getDatabase(context).rentDataSource(),
                RentsAPIDataSource.getInstance(context)).saveRent(rent)}
        catch (error:Exception) {
            Log.e("RegisterUsecase","Error in register process")

        }
    }

}