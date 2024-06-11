package com.patinfly.domain.usecase

import android.content.Context
import com.patinfly.data.dataSource.dbDataSource.AppDatabase
import com.patinfly.data.dataSource.remoteDbDataSource.RentsAPIDataSource
import com.patinfly.data.dataSource.rent.RentDataSource
import com.patinfly.data.repository.RentRepository
import com.patinfly.domain.model.remotedDataSource.RentApiModel

class GetRemoteRentUsecase {
    companion object {
        suspend fun execute(context: Context): RentApiModel? {
            return RentRepository( RentDataSource.getInstance(context), AppDatabase.getDatabase(context).rentDataSource(),
                RentsAPIDataSource.getInstance(context)).rents()}

    }
}