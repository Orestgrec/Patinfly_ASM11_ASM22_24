package com.patinfly.domain.repository

import androidx.compose.ui.text.input.TextFieldValue
import com.patinfly.domain.model.User
import java.util.UUID

interface IUserRepository {
    fun fatchUserByUUID(uuid: UUID): User?
    fun checkUserByEmail(email: TextFieldValue): User?
    fun saveUser(user: User)
    fun updateUser(user: User)
}