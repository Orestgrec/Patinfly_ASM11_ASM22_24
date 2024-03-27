package com.patinfly.domain.repository

import androidx.compose.ui.text.input.TextFieldValue
import com.patinfly.data.model.UserModel
import com.patinfly.domain.model.User
import java.util.UUID

interface IUserRepository {
    fun fetchUserByEmail(email: String?): UserModel?
    fun checkUserByEmail(email: String): String?
    fun saveUser(user: User)
    fun updateUser(user: User)
}