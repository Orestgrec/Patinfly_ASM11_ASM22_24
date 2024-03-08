package com.patinfly.domain.repository

import com.patinfly.domain.model.User
import java.util.UUID

interface UserRepository {
    fun fatchUserByUUID(uuid: UUID): User?
    fun saveUser(user: User)
    fun updateUser(user: User)
}