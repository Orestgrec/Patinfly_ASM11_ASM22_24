package com.patinfly.domain.usecase

import android.util.Log
import androidx.compose.ui.text.input.TextFieldValue
import com.patinfly.data.repository.UserRepository
import com.patinfly.domain.model.User

class LoginUsecase(private var userRepository: UserRepository) {
suspend fun execute(email: TextFieldValue ):Boolean{
    return try {
        // check if user exists
        val userUUID= userRepository.fetchUserByEmail(email.text)
        var retorn:Boolean = false
        //fetch or save data if needed
        userUUID?.let {
        //val user :User?=userRepository.fetchUserByUUID(userUUID)
            retorn=true
        }
        retorn
    }catch (error:Exception) {
        Log.e("LoginUsecase","Error in login process")
        false
    }

}
}