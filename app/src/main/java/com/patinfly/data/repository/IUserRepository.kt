package com.patinfly.data.repository

import androidx.compose.ui.text.input.TextFieldValue
import com.patinfly.data.dataSource.user.UserDao
import com.patinfly.data.model.UserModel
import java.time.LocalDateTime
import com.patinfly.domain.model.User
import com.patinfly.domain.repository.IUserRepository
import java.util.UUID

class UserRepository(
    private val userDataSource: UserDao
) : IUserRepository {


    private val userMap: MutableMap<UUID, User> = mutableMapOf()

    override fun fetchUserByEmail(email: String?): UserModel? {
        return userDataSource.fatchUserByEmail(email)
    }
     override fun checkUserByEmail(email: String): String {
        return userDataSource.checkUserByEmail(email)
    }
    override fun saveUser(user: User){
        // store the new user`s data in userMap
        userMap[user.uuid] = user
    }
    override fun updateUser(user: User){
        if (userMap.containsKey(user.uuid)) {
            userMap[user.uuid] = user
        } else {
            //we can implement exception in case the user doesn't exist
        }
    }

}