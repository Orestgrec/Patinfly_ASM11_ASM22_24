package com.patinfly.domain.usecase

import android.util.Log
import com.patinfly.data.model.UserModel
import com.patinfly.data.repository.UserRepository
import com.patinfly.domain.model.User

class ProfileDataUsecase(private var userRepository: UserRepository) {
    fun execute(email: String):User?{
        return try {

            userRepository.fetchUserByEmail(email)
        }catch (error:Exception) {
            Log.e("ProfileDataUsecase","Error in fetching process")
            null
        }
    }
}