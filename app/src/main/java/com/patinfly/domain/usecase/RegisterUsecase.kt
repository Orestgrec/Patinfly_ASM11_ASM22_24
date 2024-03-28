package com.patinfly.domain.usecase

import android.util.Log
import com.patinfly.data.repository.UserRepository
import com.patinfly.domain.model.User
import java.time.LocalDateTime
import java.util.UUID

class RegisterUsecase(private var userRepository: UserRepository) {
    fun execute(username: String, email: String): Any {
        // generate an instance from user data class and pass it to be saved
        return try {
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
            userRepository.saveUser(user)
        }catch (error:Exception) {
            Log.e("RegisterUsecase","Error in register process")
            "fail"
        }
    }

}