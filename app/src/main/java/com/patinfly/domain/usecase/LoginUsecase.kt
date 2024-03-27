package com.patinfly.domain.usecase

import android.util.Log
import androidx.compose.ui.text.input.TextFieldValue
import com.patinfly.data.repository.UserRepository

class LoginUsecase(private var userRepository: UserRepository) {
fun execute(email: TextFieldValue ):String?{
    return try {
        userRepository.checkUserByEmail(email.text)
    }catch (error:Exception) {
        Log.e("LoginUsecase","Error in login process")
        "fail"
    }
}
}