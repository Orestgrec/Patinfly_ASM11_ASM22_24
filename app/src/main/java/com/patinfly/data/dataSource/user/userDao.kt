package com.patinfly.data.dataSource.user

import android.content.Context
import androidx.compose.ui.text.input.TextFieldValue
import com.google.gson.Gson
import com.patinfly.domain.model.User
import java.io.File
import java.util.UUID

class userDao {

   /*val jsonFilePath = "../../../src/main/res/raw/user.json"

    // Read the JSON file content
    val jsonContent = File(jsonFilePath).readText()

    // Create Gson instance
    val gson = Gson()

    // Parse JSON string to a Map
    val jsonObject = gson.fromJson(jsonContent, Map::class.java)

    // Extract the email field
    val emailJson  = jsonObject["email"]
*/
    companion object {
    @Volatile
    private var instance:userDao?=null
        fun getinstance(current: Context) =
        instance?: synchronized(this)
        { instance?:userDao().also  {
            instance=it
        }}

    }
    fun fatchUserByUUID(uuid: UUID): User?{
        return TODO("Provide the return value")
    }
    fun checkUserByEmail(email: TextFieldValue): User?{
       return TODO("Provide the return value")
    }
    fun saveUser(user: User){
        return TODO("Provide the return value")
    }
    fun updateUser(user: User){
        return TODO("Provide the return value")
    }

}