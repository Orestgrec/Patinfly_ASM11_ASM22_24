package com.patinfly.domain.repository

import androidx.compose.ui.text.input.TextFieldValue
import com.patinfly.data.model.UserModel
import com.patinfly.domain.model.Rent
import com.patinfly.domain.model.Scooter
import com.patinfly.domain.model.User
import java.util.UUID

interface IUserRepository {


    fun fetchUserByEmail(email: String): User?
     fun checkUserByEmail(email: String): UUID?
     fun saveUser(user: User)
    fun updateUser(user: User)
    fun fetchUserByUUID(uuid: UUID):User?
}