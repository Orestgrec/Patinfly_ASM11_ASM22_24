package com.patinfly.domain.usecase

import android.util.Log
import androidx.compose.ui.text.input.TextFieldValue
import com.patinfly.data.repository.UserRepository

class LoginUsecase(private var userRepository: UserRepository) {
fun execute(email: TextFieldValue =""):Boolean{
    return try {
        val userUUID = userRepository.checkUserByEmail(email)
        userUUID?.let {
            // user fetched
            true
        }?:{
            // user not found
            false
        }
        true
    }catch (error:Exception) {
        Log.e("LoginUsecase","Error in login process")
        false
    }
}
}