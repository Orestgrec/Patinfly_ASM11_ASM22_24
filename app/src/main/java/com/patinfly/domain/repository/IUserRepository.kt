package com.patinfly.domain.repository

import com.patinfly.domain.model.User
import java.util.UUID

interface IUserRepository {


    suspend fun  fetchUserByEmail(email: String): User?
//    suspend fun checkUserByEmail(email: String): UUID?
    suspend fun saveUser(user: User)
//    suspend fun updateUser(user: User)
    suspend fun fetchUserByUUID(uuid: UUID):User?
}