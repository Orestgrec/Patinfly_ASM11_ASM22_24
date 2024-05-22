package com.patinfly.domain.usecase

import android.util.Log
import com.patinfly.data.repository.UserRepository
import com.patinfly.domain.model.Rent
import com.patinfly.domain.model.Scooter
import com.patinfly.domain.model.User
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

class RegisterUsecase(private var userRepository: UserRepository) {
     fun execute(username: String, email: String) {
        // generate an instance from user data class and pass it to be saved
         try {
            val uuid = UUID.randomUUID()
            val scooterRented = UUID.randomUUID()
            val creationDate =Date()

            val user = User(
                uuid,
                username,
                email,
                isRenting = false,
                scooterRented,
                creationDate,
                numberOfRents = 8

            )
            userRepository.saveUser(user)
        }catch (error:Exception) {
            Log.e("RegisterUsecase","Error in register process")

        }
    }

}