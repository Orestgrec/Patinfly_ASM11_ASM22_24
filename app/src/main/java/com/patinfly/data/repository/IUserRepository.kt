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

    companion object {
        private var instance: UserRepository? = null

        fun getInstance(userDataSource: UserDao): UserRepository {
            if (instance == null) {
                instance = UserRepository(userDataSource)
            }
            return instance!!
        }

        private val userMap: MutableMap<UUID, User> = mutableMapOf()

        // Funzione per aggiungere un nuovo utente /fun for add new user
        fun addUser(username: String, email: String) {
            val uuid = UUID.randomUUID()
            val scooterRented = UUID.randomUUID()
            val creationDate = LocalDateTime.now()
            val user = User(
                uuid,
                username,
                email,
                isRenting = false,
                scooterRented,
                creationDate,
                numberOfRents = 0
            )
            userMap[uuid] = user
        }

        // Fun to get user from uuid
        fun getUser(uuid: UUID): User? {
            return userMap[uuid]
        }

        fun deleteUser(uuid: UUID) {
            userMap.remove(uuid)
        }

    }


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
        if (userMap.containsKey(user.uuid)) {
            userMap[user.uuid] = user
        } else {
            //we can implement exception in case the user doesn't exist
        }
    }





}