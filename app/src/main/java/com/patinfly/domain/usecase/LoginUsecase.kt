package com.patinfly.domain.usecase

import android.R.attr
import android.R.attr.password
import android.util.Log
import androidx.compose.ui.text.input.TextFieldValue
import com.patinfly.data.repository.UserRepository
import com.patinfly.utils.PasswordUtils.hashPassword


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
            val storedHashedPassword: String = user.hashedPass
            val storedSalt: String = user.salt

            // Hash the input password with the stored salt

            // Hash the input password with the stored salt
            val hashedInputPassword = hashPassword(password.text, storedSalt)
            if (storedHashedPassword == hashedInputPassword){
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