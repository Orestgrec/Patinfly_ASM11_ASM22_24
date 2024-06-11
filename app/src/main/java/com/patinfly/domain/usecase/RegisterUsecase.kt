package com.patinfly.domain.usecase

import android.util.Log
import com.patinfly.data.repository.UserRepository
import com.patinfly.domain.model.User
import java.util.Date
import java.util.UUID

class RegisterUsecase(private var userRepository: UserRepository) {
     suspend fun execute(username: String, email: String,password:String) {
        // generate an instance from user data class and pass it to be saved
         try {
            val uuid = UUID.randomUUID()
            val scooterRented = UUID.randomUUID()
            val creationDate =Date()
            // for github
            val user = User(
                uuid,
                username,
                email,
                isRenting = false,
                scooterRented,
                creationDate,
                numberOfRents = 8,
                password,
            )
             userRepository.saveUser(user)
        }catch (error:Exception) {
            Log.e("RegisterUsecase","Error in register process")

        }
    }

}