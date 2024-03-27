package com.patinfly.data.repository

import androidx.compose.ui.text.input.TextFieldValue
import com.patinfly.data.dataSource.user.UserDao
import com.patinfly.data.model.UserModel

import com.patinfly.domain.model.User
import com.patinfly.domain.repository.IUserRepository
import java.util.UUID

class UserRepository(
    private val userDataSource: UserDao
) : IUserRepository {
    override fun fetchUserByEmail(email: String?): UserModel? {
        return userDataSource.fatchUserByEmail(email)
    }
     override fun checkUserByEmail(email: String): String? {
        return userDataSource.checkUserByEmail(email)
    }
    override fun saveUser(user: User){
        return TODO("Provide the return value")
    }
    override fun updateUser(user: User){
        return TODO("Provide the return value")
    }
}