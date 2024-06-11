package com.patinfly.domain.usecase

import android.util.Log
import com.patinfly.data.repository.UserRepository
import com.patinfly.domain.model.User

class ProfileDataUsecase(private var userRepository: UserRepository) {
    suspend fun execute(email: String):User?{
        return try {

            userRepository.fetchUserByEmail(email)
        }catch (error:Exception) {
            Log.e("ProfileDataUsecase","Error in fetching process")
            null
        }
    }
}