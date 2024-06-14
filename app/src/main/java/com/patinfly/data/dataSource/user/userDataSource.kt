package com.patinfly.data.dataSource.user

import android.annotation.SuppressLint
import android.content.Context
import com.patinfly.data.dataSource.dbDataSource.UserDao
import com.patinfly.domain.model.User
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

class UserDataSource constructor(
) {
    private var context: Context? = null

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var instance: UserDataSource? = null
        fun getInstance(context: Context) =
            instance ?: synchronized(this)
            {
                instance ?: UserDataSource().also {
                    instance = it
                    it.context =context
                    // assign coming data from Activity to data property
                   // it.data = data
                }
            }
      }

}