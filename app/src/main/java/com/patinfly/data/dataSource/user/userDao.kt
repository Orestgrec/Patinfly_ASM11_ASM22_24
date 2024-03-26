package com.patinfly.data.dataSource.user

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.loader.AssetsProvider
import androidx.compose.ui.text.input.TextFieldValue
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import com.patinfly.data.model.UserModel
import com.patinfly.domain.model.User
import com.patinfly.utils.ReadJSONFromAssets
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.util.UUID

class userDao constructor(
) {
    private var context: Context? = null
    fun loadUserData() {
        context?.let {
            val stringDataFromRawAsset: String= ReadJSONFromAssets(context!!,"user.json")
            stringDataFromRawAsset.let {
                val user: UserModel? = parseJson(it)
                user?.let {
                    this.saveUser(user)
                }
            }
        }


    }

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
        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var instance: userDao? = null
        fun getinstance(context: Context) =
            instance ?: synchronized(this)
            {
                instance ?: userDao().also {
                    instance = it
                    it.context =context
                    it.loadUserData()
                }
            }

        private val usersUUIDMap: MutableMap<UUID, UserModel> = HashMap()
        private val usersMailMap: MutableMap<String, UserModel> = HashMap()


        private fun parseJson(json: String): UserModel? {
        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssz").create()
            return try {
                gson.fromJson(json,UserModel::class.java)
            }catch (e:JsonSyntaxException){
                e.printStackTrace()
                null
            }            }
        }
    fun fatchUserByUUID(uuid: UUID): User? {
        return TODO("Provide the return value")
    }
    fun checkUserByEmail(email: TextFieldValue): User? {
        return TODO("Provide the return value")
    }

    private fun saveUser(user: UserModel) {
        return TODO("Provide the return value")
    }

    fun updateUser(user: User) {
        return TODO("Provide the return value")
    }


}