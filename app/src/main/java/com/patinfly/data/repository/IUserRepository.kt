package com.patinfly.data.repository

import android.util.Log
import com.patinfly.data.dataSource.dbDataSource.RentDao
import com.patinfly.data.dataSource.dbDataSource.ScooterDao
import com.patinfly.data.dataSource.dbDataSource.UserDao
import com.patinfly.data.dataSource.user.UserDataSource
import com.patinfly.domain.model.Rent
import com.patinfly.domain.model.Scooter
import com.patinfly.domain.model.User
import com.patinfly.domain.model.dbDatasource.RentEntity
import com.patinfly.domain.model.dbDatasource.ScooterEntity
import com.patinfly.domain.model.dbDatasource.UserEntity
import com.patinfly.domain.model.dbDatasource.toRentDomain
import com.patinfly.domain.model.dbDatasource.toUserDomain
import com.patinfly.domain.repository.IUserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.UUID

class UserRepository(
    private val userDataSource: UserDataSource,
    private val userDao: UserDao,
    private val scooterDao: ScooterDao,
) : IUserRepository {


    private val userMap: MutableMap<UUID, User> = mutableMapOf()

    override  fun fetchUserByEmail(email: String): User? {
        return try {
            runBlocking {
                val deferred = async(Dispatchers.IO) {
                    userDao.getUserByMail(email)?.toUserDomain()
                }
                deferred.await()
            }
        } catch (error: Exception) {
            Log.e("saveRent", "Error in fetching process")
            null
        }
    }
    override fun fetchUserByUUID(uuid: UUID):User?{
        return try {
            runBlocking {
                val deferred = async(Dispatchers.IO) {
                    userDao.getUserByUUID(uuid)?.toUserDomain()
                }
                deferred.await()
            }
        } catch (error: Exception) {
            Log.e("saveRent", "Error in fetching process")
            null
        }

    }

     override fun checkUserByEmail(email: String): UUID? {
//         val userByMail:User? = userDao.getUserByMail(email)?.toUserDomain()
//         return if (userByMail !=null) {
//             userByMail.uuid
//         }
//         else {
//         //get information from external source (json)
//         val user = userDataSource.fatchUserByEmail(email)
//         //add user to DB
//         user?.let{
//             GlobalScope.launch(Dispatchers.IO) {
//                 userDao.save(UserEntity.fromUserDomain(user))
//             }        }
//             user?.uuid
//         }
         TODO("Not yet implemented")
    }
    override fun saveUser(user: User){
        // store the new user`s data in database
        try {
            GlobalScope.launch(Dispatchers.IO) {
                userDao.save(UserEntity.fromUserDomain(user))
            }
        }catch (error:Exception) {
            Log.e("saveRent","Error in save process")
        }
    }
     override fun updateUser(user: User){
         TODO("Not yet implemented")
    }

}