package com.patinfly.data.dataSource.rent

import android.annotation.SuppressLint
import android.content.Context
import com.patinfly.data.dataSource.scooter.ScooterDataSource
import com.patinfly.domain.model.Rent
import org.json.JSONArray
import java.util.UUID
class RentDataSource {
     private var context: Context? = null

     companion object {
          @SuppressLint("StaticFieldLeak")
          @Volatile
          private var instance: RentDataSource? = null
          fun getInstance(context: Context) =
               instance ?: synchronized(this)
               {
                    instance ?: RentDataSource().also {
                         instance = it
                         it.context =context
                         // assign coming data from Activity to data property
                    }
               }
     }
//     fun saveRent(rent: Rent) {}
//     fun fetchRents(): List<Rent> {}
//     fun fetchRentByUUID(uuid: UUID): Rent? {}
}