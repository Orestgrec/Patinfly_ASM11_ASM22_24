package com.patinfly.data.repository

import com.patinfly.data.dataSource.rent.RentDao
import com.patinfly.data.dataSource.user.userDao
import com.patinfly.domain.model.User
import com.patinfly.domain.repository.IUserRepository
import java.util.UUID
import javax.sql.CommonDataSource

class UserRepository (
    private val userDataSource: userDao
) : IUserRepository {
    override fun fatchUserByUUID(uuid: UUID): User? {
        return TODO("Provide the return value")
    }
    override fun checkUserByEmail(email: String): User?{
        return userDataSource.checkUserByEmail(email)
    }
    override fun saveUser(user: User){
        return TODO("Provide the return value")
    }
    override fun updateUser(user: User){
        return TODO("Provide the return value")
    }
}