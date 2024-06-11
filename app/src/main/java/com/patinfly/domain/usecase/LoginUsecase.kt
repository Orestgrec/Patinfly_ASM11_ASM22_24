package com.patinfly.domain.usecase

import android.util.Log
import androidx.compose.ui.text.input.TextFieldValue
import com.patinfly.data.repository.UserRepository

class LoginUsecase(private var userRepository: UserRepository) {
suspend fun execute(email: TextFieldValue ,password:TextFieldValue ):Boolean{
    return try {
        // check if user exists
        val user= userRepository.fetchUserByEmail(email.text)
        var retorn = false
        Log.e("LoginUsecase",user?.username.toString())

        Log.e("LoginUsecase",email.text)

        //fetch or save data if needed
        user?.let {
        //val user :User?=userRepository.fetchUserByUUID(userUUID)

            if (password.text ==user.password ){
                retorn=true
            }
        }
        Log.e("LoginUsecase",password.text)
        Log.e("LoginUsecase",retorn.toString() )

        retorn
    }catch (error:Exception) {
        Log.e("LoginUsecase","Error in login process")
        false
    }

}
}