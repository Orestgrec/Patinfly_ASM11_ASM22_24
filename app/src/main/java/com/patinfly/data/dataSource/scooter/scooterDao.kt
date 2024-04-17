package com.patinfly.data.dataSource.scooter

import android.annotation.SuppressLint
import android.content.Context
import com.patinfly.data.dataSource.user.UserDao
import com.patinfly.data.model.UserModel
import org.json.JSONArray
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

class ScooterDao constructor(
) {
    private var context: Context? = null
    private var data:JSONArray?=null

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var instance: ScooterDao? = null
        fun getInstance(context: Context, data: JSONArray?) =
            instance ?: synchronized(this)
            {
                instance ?: ScooterDao().also {
                    instance = it
                    it.context =context
                    // assign coming data from Activity to data property
                    it.data = data
                }
            }
    }

}