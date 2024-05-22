package com.patinfly.domain.usecase

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import com.patinfly.data.dataSource.dbDataSource.AppDatabase
import com.patinfly.data.dataSource.rent.RentDataSource
import com.patinfly.data.repository.RentRepository
import com.patinfly.data.repository.ScooterRepository
import com.patinfly.domain.model.Rent
import com.patinfly.domain.model.Scooter

class GetRentsUsecase {
    fun execute(context: Context): List<Rent> {
        return RentRepository(RentDataSource.getInstance(context),
            AppDatabase.getDatabase(context).rentDataSource()).fetchRents()
    }
}