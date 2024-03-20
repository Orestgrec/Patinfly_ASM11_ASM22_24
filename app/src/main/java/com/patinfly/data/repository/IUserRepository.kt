package com.patinfly.data.repository

import androidx.compose.ui.text.input.TextFieldValue
import com.patinfly.data.dataSource.user.userDao
import com.patinfly.domain.model.User
import com.patinfly.domain.repository.IUserRepository
import java.util.UUID

class UserRepository(
    private val userDataSource: userDao.Companion
) : IUserRepository {
    override fun fatchUserByUUID(uuid: UUID): User? {
        return TODO("Provide the return value")
    }
    override fun checkUserByEmail(email: TextFieldValue): User?{
        return userDataSource.checkUserByEmail(email)
    }
    override fun saveUser(user: User){
        return TODO("Provide the return value")
    }
    override fun updateUser(user: User){
        return TODO("Provide the return value")
    }
}