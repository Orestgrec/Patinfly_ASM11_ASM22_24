package com.patinfly.data.dataSource.user

import android.annotation.SuppressLint
import android.content.Context
import com.patinfly.data.dataSource.dbDataSource.UserDao
import com.patinfly.domain.model.User
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

class UserDataSource constructor(
) {
    private var context: Context? = null

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var instance: UserDataSource? = null
        fun getInstance(context: Context) =
            instance ?: synchronized(this)
            {
                instance ?: UserDataSource().also {
                    instance = it
                    it.context =context
                    // assign coming data from Activity to data property
                   // it.data = data
                }
            }
      }
    fun fatchUserByEmail(interedEmail: String?):User? {
//        val max = data?.length()
//        for (i in 0..max!!) {
//            val email = data?.getJSONObject(i)?.getString("email")
//            if (email==interedEmail) {
//
//                val userName: String? = data?.getJSONObject(i)?.getString("username")
//
//                // the data coming from json is always String so we have to convert it to the desired data type before get our instance from the data class
//                val uuid: String? = data?.getJSONObject(i)?.getString("uuid")
//                val uuidConverted: UUID = UUID.fromString(uuid)
//
//                val email: String? = data?.getJSONObject(i)?.getString("email")
//                val isRenting: Boolean? = data?.getJSONObject(i)?.getString("isRenting")?.toBoolean()
//
//                // the data coming from json is always String so we have to convert it to the desired data type before get our instance from the data class
//                val scooterRented: String? = data?.getJSONObject(i)?.getString("scooterRented")
//                val scooterRentedConverted: UUID = UUID.fromString(scooterRented)
//
//                // the data coming from json is always String so we have to convert it to the desired data type before get our instance from the data class
//                val creationDate: String? = data?.getJSONObject(i)?.getString("creationDate")
//                val dateFormatter =DateTimeFormatter.ISO_LOCAL_DATE_TIME
//                val localDateTime: LocalDateTime? = LocalDateTime.parse(creationDate, dateFormatter)
//
//
//                val numberOfRents: Int? =
//                    data?.getJSONObject(i)?.getString("numberOfRents")?.toInt()
//
//                return User(
//                    username = userName,
//                    scooterRented = scooterRentedConverted,
//                    email = email,
//                    creationDate = localDateTime,
//                    uuid = uuidConverted,
//                    isRenting = isRenting,
//                    numberOfRents = numberOfRents
//                )
//
//            }
//        }
        return null
//
    }

    fun checkUserByEmail(interedEmail: String): String {
//        val max = data?.length()
//        for (i in 0..max!!) {
//            val email = data?.getJSONObject(i)?.getString("email")
//            if (email==interedEmail){
//                return "user approved"
//            }
//        }
            return "wrong credentials"
    }

}