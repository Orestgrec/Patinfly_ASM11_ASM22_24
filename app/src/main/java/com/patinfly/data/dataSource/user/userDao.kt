package com.patinfly.data.dataSource.user

import android.content.Context
import com.patinfly.domain.model.User
import java.util.UUID

interface userDao {
    fun fatchUserByUUID(uuid: UUID): User?
    fun checkUserByEmail(email: String): User?
    fun saveUser(user: User){
    }
    fun updateUser(user: User)

    companion object {
        fun getInstance(current: Context): Companion {
        return userDao
        }
    }
}