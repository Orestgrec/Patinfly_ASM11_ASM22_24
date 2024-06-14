package com.patinfly.data.repository

import android.util.Log
import com.patinfly.data.dataSource.dbDataSource.ScooterDao
import com.patinfly.data.dataSource.dbDataSource.UserDao
import com.patinfly.data.dataSource.user.UserDataSource
import com.patinfly.domain.model.User
import com.patinfly.domain.model.dbDatasource.UserEntity
import com.patinfly.domain.model.dbDatasource.toUserDomain
import com.patinfly.domain.repository.IUserRepository
import java.util.UUID

class UserRepository(
    private val userDataSource: UserDataSource,
    private val userDao: UserDao,
    private val scooterDao: ScooterDao,
) : IUserRepository {


    override suspend fun fetchUserByEmail(email: String): User? {
        return try {
            userDao.getUserByMail(email)?.toUserDomain()

        } catch (error: Exception) {
            Log.e("fetchUserByEmail", "Error in fetching process", error)
            null
        }
    }

    override suspend fun fetchUserByUUID(uuid: UUID): User? {
        return try {
                userDao.getUserByUUID(uuid)?.toUserDomain()

        } catch (error: Exception) {
            Log.e("fetchUserByUUID", "Error in fetching process", error)
            null
        }
    }

//     override suspend fun checkUserByEmail(email: String): UUID? {
//    }
    override suspend fun saveUser(user: User){
        // store the new user`s data in database
        try {
            Log.e("saveRent",user.hashedPass)

            userDao.save(UserEntity.fromUserDomain(user))
        }catch (error:Exception) {
            Log.e("saveRent","Error in save process")
        }
    }
//     override suspend fun updateUser(user: User){
//    }

}