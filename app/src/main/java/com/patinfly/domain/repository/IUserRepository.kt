package com.patinfly.domain.repository

import com.patinfly.domain.model.User
import java.util.UUID

interface IUserRepository {
    fun fatchUserByUUID(uuid: UUID): User?
    fun checkUserByEmail(email: String): User?
    fun saveUser(user: User)
    fun updateUser(user: User)
}